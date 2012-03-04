package com.lightningrod.dropbox;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.WebAuthSession;
import com.dropbox.client2.session.WebAuthSession.WebAuthInfo;
import com.lightningrod.app.BareBonesBrowserLaunch;
import java.io.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Convenience class for Dropbox methods.
 * @author Kevin Conley
 */
public class DBApi {
	final static private String APP_KEY = "icbm0h0d2th6cm5";
	final static private String APP_SECRET = "7x7g643tj17wm7w";
	
	final static private AccessType ACCESS_TYPE = AccessType.DROPBOX;
	
        final static public String ROOT_FOLDER = "lightning_rod";
        
	private DropboxAPI<WebAuthSession> mDBApi;
	private WebAuthSession session;
	private AppKeyPair appKeys;
	private WebAuthInfo auth;
	
	private Entry root;
        private String root_drive;
	
        /**
         * 
         */
        public DBApi(String rd) {
		//create dropbox api and session objects based on app key/secret
		this.appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
		this.session = new WebAuthSession(appKeys, ACCESS_TYPE);
		this.mDBApi = new DropboxAPI<WebAuthSession>(session);
                
                this.root_drive = rd;
	}
	
        /**
         * Login user to Dropbox.
         * @return True if successful, false otherwise.
         */
        public boolean login() {
		if (!this.authorize()) {
			return false;
		} else {
			//TODO stop here so user can confirm app approval 
			Scanner readUserInput=new Scanner(System.in); 
			System.out.println("Press enter after "
                                + "approving Lightning Rod.");
			readUserInput.nextLine(); 
			
			return authenticate();
		}
	}
	
	private boolean authorize() {
		try {
			//construct app authorization URL
			this.auth = this.session.getAuthInfo("http://www.google.com");
			System.out.println("url: " + this.auth.url);
			//launch browser for user to approve app
			BareBonesBrowserLaunch.openURL(this.auth.url);
			
			return true;
		} catch (DropboxException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
		
	}
	
	private boolean authenticate() {
		try {
			session.retrieveWebAccessToken(auth.requestTokenPair);
			return true;
		} catch (DropboxException ex) {
			// TODO Auto-generated catch block
                        Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}	
	}
	
        /**
         * Construct the tree, using pre-order recursive traversal.
         * @param node The Entry node used to start the traversal.
         */
        public void treeDir(Entry node) {
		if (node == null)
			node = updateTree(node);
		else if (node.isDir)
			node = updateTree(node);
		System.out.println(node.fileName());
                //downloadFile(node);
		if(node.contents == null)
			return;
		for (Entry e : node.contents) {
			//TODO construct tree for Bill
			//System.out.print("\t");
			treeDir(e);
		}
	}
	
        //
        /**
         * Update tree from node's perspective (just one level of children).
         * @param node Entry node to update.
         * @return The updated Entry node, otherwise null.
         */
        public Entry updateTree(Entry node) {
		String path;
		if (node == null) {
			path = "/";
		} else {
			path = node.path;
			System.out.println(path);
		}
		try {
			return mDBApi.metadata(path, 0, null, true, null);
		} catch (DropboxException ex) {
			Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}
	
        /**
         * Update and return the root Entry node.
         * @return The updated root Entry node.
         */
        public Entry getRoot() {
		return (this.root = updateTree(root));
	}

        //
        //creates parent directories if necessary
        //return new Dropbox entry or null if failed
        /**
         * Add completely new file to Dropbox.
         * @param f The File object to add to Dropbox.
         * @return The Dropbox Entry node for the new file, or null otherwise.
         */
        public Entry addFile(File f) {
            if (f == null) 
                return null;
            String strip = root_drive + ROOT_FOLDER;
            System.out.println(strip);
            System.out.println(f.getAbsolutePath());
            String path = f.getAbsolutePath().replaceFirst(strip, "");
            System.out.println(path);
            try {
                InputStream in = new FileInputStream(f);
                return mDBApi.putFile(path, in, f.length(), null, null);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } catch (DropboxException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            
        }
    
        /**
         * Update file on Dropbox based on local modification.
         * @param se Key/value pair for Dropbox Entry and File object to modify.
         * @return True if successful, false otherwise.
         */
        public boolean updateFile(SimpleEntry<Entry, File> se) {
            Entry e = se.getKey();
            File f = se.getValue();
            
            if (e == null || f == null)
                return false;
            
            try {
                InputStream in = new FileInputStream(f);
                mDBApi.putFile(e.path, in, f.length(), e.rev, null);
                return true;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } catch (DropboxException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
            
        /**
         * Delete file from Dropbox's server.
         * @param node The Dropbox Entry node to delete from their server.
         * @return True if successful, false otherwise.
         */
        public boolean deleteFile(Entry node) {
            try {
                mDBApi.delete(node.path);
                return true;
            } catch (DropboxException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }

        /**
         * Download file from Dropbox to local file system.
         * Note: Doesn't take into account whether file already exists or not.
         *      That's up to us to decide whether or not it matters.
         * @param node
         * @return File object of downloaded file, null otherwise.
         */
        public File downloadFile(Entry node) {
            if (node == null)
                return null;
            File f = new File(getLocalPath(node.path));
            try {
                if (node.isDir) {
                    f.mkdirs();
                } else {
                    f.getParentFile().mkdirs();
                    f.createNewFile();
                    OutputStream out = new FileOutputStream(f);

                    mDBApi.getFile(node.path, null, out, null);
                }
                return f;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                f.delete();
                return null;
            } catch (IOException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } catch (DropboxException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }

        /**
         * Construct absolute path for a filename.
         * @param path The file name to add the local file system path to.
         * @return The absolute path on the file system.
         */
        public String getLocalPath(String path) {
            return root_drive + ROOT_FOLDER + File.separator + path;
        }
        
        /**
         * Logout user from session.
         */
        public void logout() {
		session.unlink();
	}
        
        
	
}