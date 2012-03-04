package com.lightningrod.app;

import com.lightningrod.dropbox.DBApi;
import com.lightningrod.dropbox.DBSync;
import com.lightningrod.gui.DBNode;
import com.lightningrod.io.Backup;
import com.lightningrod.io.FileMonitorAdvanced;
import java.io.File;

/**
 *
 * @author kevin
 */
public class LightningRod {
        private static String root_drive;
        private static String root_path;
        
        /**
	 * @param args
	 */
	public static void main(String[] args) {
		String pwd = new File(".").getAbsolutePath();
                root_drive = String.valueOf(pwd.charAt(0));
                if (!(root_drive.equals("/")))
                    root_drive = root_drive + ":" + File.separator;
                
                root_path = root_drive + DBApi.ROOT_FOLDER;
            
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
                
                //create Dropbox folder
                new File(root_path).mkdir();
                
                //create file monitoring object
                FileMonitorAdvanced monitor = new FileMonitorAdvanced (3000L, 5000L,
                new File(root_path));
                
                //create db api object
		DBApi db = new DBApi(root_drive, monitor);
                
                //create Dropbox sync monitoring object
                DBSync sync = new DBSync(monitor, 3000L, db);
                
		//login
		if (!db.login()) {
                    //login failed
                    return;
		} else {
                    //download entire Dropbox folder, add file monitors
                    DBNode rootnode = db.treeDir(db.getRoot());
                    
                    // Initialize GUI and Populate File Architecture
                    com.lightningrod.gui.LRgui.setupGUI(rootnode);

                    //start file monitoring timer
                    monitor.addListener(monitor);
                    monitor.startTimer();
                    
                    //start Dropbox sync timer
                    sync.startTimer();
                    while(true);
                }

		//db.logout();
	}
}
