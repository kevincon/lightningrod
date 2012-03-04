package com.lightningrod.app;

import com.lightningrod.dropbox.DBApi;
import java.io.File;

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
                        //db.getRoot();
                        
                        //File f = new File(db.getLocalPath("testdir/test.txt"));
                        //db.addFile(f);
		}

		db.disconnect();
	}

}
