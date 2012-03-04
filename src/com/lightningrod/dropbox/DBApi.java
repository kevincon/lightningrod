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

public class DBApi {
	final static private String APP_KEY = "icbm0h0d2th6cm5";
	final static private String APP_SECRET = "7x7g643tj17wm7w";
	
	final static private AccessType ACCESS_TYPE = AccessType.DROPBOX;
	
	private DropboxAPI<WebAuthSession> mDBApi;
	private WebAuthSession session;
	private AppKeyPair appKeys;
	private WebAuthInfo auth;
	
	private Entry root;
	
	public DBApi() {
		//create dropbox api and session objects based on app key/secret
		this.appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
		this.session = new WebAuthSession(appKeys, ACCESS_TYPE);
		this.mDBApi = new DropboxAPI<WebAuthSession>(session);
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
			updateTree(node);
		else if (node.isDir)
			updateTree(node);
		System.out.println(node.fileName());
		if(node.contents == null)
			return;
		for (Entry e : node.contents) {
			//TODO instead of printing out here, construct tree for Bill
			System.out.print("\t");
			treeDir(e);
		}
	}
	
	public boolean updateTree(Entry node) {
		String path;
		if (node == null) {
			path = "/";
		} else {
			path = node.path;
			System.out.println(path);
		}
		try {
			node = mDBApi.metadata(path, 0, null, true, null);
			return true;
		} catch (DropboxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public Entry getRoot() {
		return this.root;
	}

	public void disconnect() {
		session.unlink();
	}
	
}
