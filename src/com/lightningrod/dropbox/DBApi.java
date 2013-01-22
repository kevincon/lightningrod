package com.lightningrod.dropbox;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.WebAuthSession;
import com.dropbox.client2.session.WebAuthSession.WebAuthInfo;
import com.lightningrod.app.BareBonesBrowserLaunch;
import com.lightningrod.gui.DBNode;
import com.lightningrod.gui.LRgui;
import com.lightningrod.io.FileMonitorAdvanced;
import java.io.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 * Convenience class for Dropbox methods.
 * @author Kevin Conley
 */
public class DBApi {
	final static private String APP_KEY = "FILLMEIN";
	final static private String APP_SECRET = "FILLMEIN";

	final static private AccessType ACCESS_TYPE = AccessType.DROPBOX;

        //final static public String ROOT_FOLDER = "Users/bill/Downloads/testdb";
        final static public String ROOT_FOLDER = "home/monk/testdb";

	private DropboxAPI<WebAuthSession> mDBApi;
	private WebAuthSession session;
	private AppKeyPair appKeys;
	private WebAuthInfo auth;

	private Entry root;
        private String root_drive;
        private FileMonitorAdvanced monitor;

        public HashSet <String>pathnames;

        /**
         *
         */
        public DBApi(String rd, FileMonitorAdvanced monitor) {
		//create dropbox api and session objects based on app key/secret
		this.appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
		this.session = new WebAuthSession(appKeys, ACCESS_TYPE);
		this.mDBApi = new DropboxAPI<WebAuthSession>(session);
                this.pathnames = new HashSet<String>();
                this.root_drive = rd;
                this.monitor = monitor;
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
			/*
                        Scanner readUserInput=new Scanner(System.in);
			System.out.println("Press enter after "
                                + "approving Lightning Rod.");
			readUserInput.nextLine();
			*/

                    LRgui.display_dialog("Please Approve LightningRod");



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
         * @return The constructed DBNode.
         */
        public DBNode treeDir(Entry node) {
		if (node == null)
			node = updateTree(node);
		else if (node.isDir)
			node = updateTree(node);
		System.out.println(node.fileName());
                //
                DBNode n = new DBNode(node);
                //File ret = downloadFile(node);
                //if (ret != null) {
                    //this.monitor.addFile(ret, node);
                //}
		if(node.contents == null)
			return n;
		for (Entry e : node.contents) {
			//TODO construct tree for Bill
			//System.out.print("\t");
			n.add(treeDir(e));
		}
                return n;
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

        // Returns the Dropbox free space in Megabytes, or -1 if it was not
        // retrievable.
        public int getDropboxFreeSpace() {
            int percentInUse = 0;
            try {
                percentInUse = (int) ((mDBApi.accountInfo().quotaNormal +
                                    mDBApi.accountInfo().quotaShared) /
                                   ((double)mDBApi.accountInfo().quota) * 100.0);
            } catch (DropboxException e) {
                System.out.println("Unable to retrieve Dropbox free space. "
                        + "Error: " + e.toString());
            }
            return percentInUse;
        }

        // Returns the root drive free space in Megabytes, or -1 if it was not
        // retrievable.
        public int getRootFreeSpace() {
            int percentInUse = 0;
            try {
                File r = new File(root_drive);
                percentInUse = (int) (((r.getTotalSpace() - r.getFreeSpace()) /
                               (double)r.getTotalSpace()) * 100.0);
            } catch (SecurityException e) {
                System.out.println("Unable to retrieve root drive free space. "
                        + "Error: " + e.toString());
            }
            return percentInUse;
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
            monitor.setTimerNoop();
            String strip = root_drive + ROOT_FOLDER;
            //System.out.println(strip);
            //System.out.println(f.getAbsolutePath());
            String path = f.getAbsolutePath().replaceFirst(strip, "");
            //System.out.println(path);
            if (f.isDirectory()) {
                Entry ret = null;
                try {
                    ret = mDBApi.createFolder(path);
                    this.monitor.addFile(f, ret);
                    pathnames.add(ret.path);
                } catch (DropboxException ex) {
                    Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    monitor.clearTimerNoop();
                    return ret;
                }

            } else {
                Entry ret = null;
                try {
                    InputStream in = new FileInputStream(f);
                    ret = mDBApi.putFile(path, in, f.length(), null, null);
                    this.monitor.addFile(f, ret);
                    pathnames.add(ret.path);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DropboxException ex) {
                    Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                }  finally {
                    monitor.clearTimerNoop();
                    return ret;
                }
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

            if (f.isDirectory())
                return false;

            monitor.setTimerNoop();
            if (!f.exists()) {
                monitor.clearTimerNoop();
                return false;
            }

            boolean result = false;
            try {
                InputStream in = new FileInputStream(f);
                mDBApi.putFile(e.path, in, f.length(), e.rev, null);
                result = true;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                result = false;
            } catch (DropboxException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                result = false;
            } finally {
                monitor.clearTimerNoop();
                return result;
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
         * Delete file from local file system.
         * @param node The Dropbox Entry node to delete from file system.
         * @return True if successful, false otherwise.
         */
        public boolean deleteLocalFile(Entry node) {
            monitor.setTimerNoop();
            File f = new File(getLocalPath(node.path));
            this.monitor.removeFile(f);
            boolean ret = FileUtils.deleteQuietly(f);
            monitor.clearTimerNoop();
            return ret;
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
            monitor.setTimerNoop();
            File f = new File(getLocalPath(node.path));
            try {
                this.monitor.addFile(f, node);
                if (node.isDir) {
                    f.mkdirs();
                } else {
                    f.getParentFile().mkdirs();
                    f.createNewFile();
                    OutputStream out = new FileOutputStream(f);

                    mDBApi.getFile(node.path, null, out, null);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                f.delete();
                f = null;
            } catch (IOException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                f = null;
            } catch (DropboxException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                f = null;
            } finally {
                monitor.clearTimerNoop();
                return f;
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