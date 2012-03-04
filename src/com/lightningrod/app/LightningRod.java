package com.lightningrod.app;

import com.lightningrod.dropbox.DBApi;
import com.lightningrod.io.Backup;
import java.io.File;

/**
 *
 * @author kevin
 */
public class LightningRod {
        private static String root_drive;
        
        /**
	 * @param args
	 */
	public static void main(String[] args) {
		String pwd = new File(".").getAbsolutePath();
                root_drive = String.valueOf(pwd.charAt(0));
                if (!(root_drive.equals("/")))
                    root_drive = root_drive + ":" + File.separator;
                
                String root_path = root_drive + DBApi.ROOT_FOLDER;
            
                //backup Dropbox folder if it exists
                if (new File(root_path).exists()) {
                    String new_dir_base = DBApi.ROOT_FOLDER + "_backup";
                    String new_dir = new_dir_base;
                    int counter = 0;
                    while(!Backup.backupFolder(root_path, new_dir)) {
                        counter++;
                        new_dir = new_dir_base + counter;
                    }
                    //TODO Warn user that Dropbox folder was backed up.
                }
                
                //create db api object
		DBApi db = new DBApi(root_drive);
		
		//login
		if (!db.login()) {
			//login failed
			return;
		} else {	
			//download entire Dropbox folder
			db.treeDir(db.getRoot());
                        
                        //start file monitoring timer
                        
                        //start Dropbox sync timer
                        
                        while(true);
		}

		db.logout();
	}
}