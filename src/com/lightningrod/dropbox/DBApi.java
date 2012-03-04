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

public class DBApi {
	final static private String APP_KEY = "icbm0h0d2th6cm5";
	final static private String APP_SECRET = "7x7g643tj17wm7w";
	
	final static private AccessType ACCESS_TYPE = AccessType.DROPBOX;
	
        final static private String ROOT_FOLDER = "lightning_rod";
        
	private DropboxAPI<WebAuthSession> mDBApi;
	private WebAuthSession session;
	private AppKeyPair appKeys;
	private WebAuthInfo auth;
	
	private Entry root;
        private String root_drive;
	
	public DBApi() {
		//create dropbox api and session objects based on app key/secret
		this.appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
		this.session = new WebAuthSession(appKeys, ACCESS_TYPE);
		this.mDBApi = new DropboxAPI<WebAuthSession>(session);
                
                File pwd = new File(".");
                this.root_drive = String.valueOf(pwd.getAbsolutePath().charAt(0));
                if (!(this.root_drive.equals("/")))
                    this.root_drive = this.root_drive + ":" + File.separator;
                System.out.println("test:\t" + this.getLocalPath("testfile.txt"));
	}
	
	public boolean login() {
		if (!this.authorize()) {
			return false;
		} else {
			//TODO need a way to stop here so user can confirm they've approved the app 
			
			//let user let us know they've authorized the app
			
			Scanner readUserInput=new Scanner(System.in); 
			System.out.println("Press enter after approving Lightning Rod.");
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
	
        //construct the tree, using pre-order recursive traversal
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
			//TODO instead of printing out here, construct tree for Bill
			//System.out.print("\t");
			treeDir(e);
		}
	}
	
        //update tree from node's perspective (just one level of children)
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
	
	public Entry getRoot() {
		return (this.root = updateTree(root));
	}

        //add file to Dropbox
        //creates parent directories if necessary
        //return new Dropbox entry or null if failed
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
    
        //update local file on Dropbox
        //return true if successful, false otherwise
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
            
        
        //delete file from Dropbox
        //returns true if successful, false otherwise
        public boolean deleteFile(Entry node) {
            try {
                mDBApi.delete(node.path);
                return true;
            } catch (DropboxException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        
        
        //download file described by node
        //does not take into account whether file already exists or not
        //that's up to us to decide whether or not it matters
        //returns File object if successful, null otherwise
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
        
        //Add on "ROOT_FOLDER/path" to root_drive
        private String getLocalPath(String path) {
            return root_drive + ROOT_FOLDER + File.separator + path;
        }
        
        //disconnect API, remove user session
	public void disconnect() {
		session.unlink();
	}
	
}
