package com.lightningrod.app;

import com.lightningrod.dropbox.DBApi;

public class DBTest {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//create db api object
		DBApi db = new DBApi();
		
		//login
		if (!db.login()) {
			//login failed
			return;
		} else {
			//login succeeded, get meta data
			//db.updateTree(null);
			
			//print out tree
			db.treeDir(db.getRoot());
		}

		db.disconnect();
	}

}
