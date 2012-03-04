package com.lightningrod.dropbox;

import java.util.Scanner;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.WebAuthSession;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.WebAuthSession.WebAuthInfo;
import com.lightningrod.app.BareBonesBrowserLaunch;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
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
                System.out.println("test:\t" + getLocalPath("testfile.txt"));
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
		} catch (DropboxException e) {
			// TODO Auto-generated catch block
			System.out.println("error after trying to get user to approve app");
			e.printStackTrace();
			return false;
		}
		
	}
	
	private boolean authenticate() {
		try {
			session.retrieveWebAccessToken(auth.requestTokenPair);
			return true;
		} catch (DropboxException e) {
			// TODO Auto-generated catch block
			System.out.println("error after trying to authenticate user");
			e.printStackTrace();
			return false;
		}	
	}
	
	public void treeDir(Entry node) {
		if (node == null)
			node = updateTree(node);
		else if (node.isDir)
			node = updateTree(node);
		System.out.println(node.fileName());
		if(node.contents == null)
			return;
		for (Entry e : node.contents) {
			//TODO instead of printing out here, construct tree for Bill
			//System.out.print("\t");
			treeDir(e);
		}
	}
	
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
		} catch (DropboxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Entry getRoot() {
		return (this.root = updateTree(root));
	}
/*
        //add file to Dropbox
        public addFile() {
            
        }
        
        //delete file from Dropbox
        public deleteFile() {
            
        }
        */
        
        public File downloadFile(Entry node) {
            if (node == null)
                return null;
            File f = new File(getLocalPath(node.path));
            try {
                OutputStream out = new FileOutputStream(f);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            try {
                mDBApi.getFile(node.path, null, null, null);
                return f;
            } catch (DropboxException ex) {
                Logger.getLogger(DBApi.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        
        //Add on "ROOT_FOLDER/path" to root_drive
        private String getLocalPath(String path) {
            return root_drive + ROOT_FOLDER + File.separator + path;
        }
        
	public void disconnect() {
		session.unlink();
	}
	
}
