/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightningrod.dropbox;

import com.dropbox.client2.DropboxAPI.Entry;
import com.lightningrod.io.FileMonitorAdvanced;
import com.lightningrod.dropbox.DBApi;
import java.io.File;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;

/**
 *
 * @author monk
 */
public class DBSync {
    private final FileMonitorAdvanced fileMonitor_;
    private final long queuePollingInterval_;
    private Timer timer_;
    private DBApi db;

    public DBSync(FileMonitorAdvanced fileMonitor,
                  long queuePollingInterval, DBApi db) {
        fileMonitor_ = fileMonitor;
        queuePollingInterval_ = queuePollingInterval;
        this.db = db;
    }
    
     public void startTimer() {
        timer_ = new Timer(true);
        timer_.schedule(new DBSyncTimer(), 0, queuePollingInterval_);
    }

    public void stopTimer() {
        timer_.cancel();
    }
    
    private class DBSyncTimer extends TimerTask {
        @Override
        public void run() {
            // Kick off a thread to do the adding / removing / updating?
            
            // Added files.
            try {
                Iterator itrAdded = fileMonitor_.filesAdded.iterator();
                while(itrAdded.hasNext()) {
                    File fileAdded = (File)itrAdded.next();
                    System.out.println("Adding file to dropbox: "
                                        + fileAdded.toString());
                    db.addFile(fileAdded);
                    itrAdded.remove();
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("Error while adding file to dropbox: "
                                    + e.toString());
            }
            
            // Removed files.
            try {
                Iterator itrRemoved = fileMonitor_.filesRemoved.iterator();
                while(itrRemoved.hasNext()) {
                    Entry entryRemoved = (Entry)itrRemoved.next();
                    System.out.println("Removing file from dropbox: "
                                        + entryRemoved.toString());
                    db.deleteFile(entryRemoved);
                    itrRemoved.remove();
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("Error while removing entry from dropbox: "
                                    + e.toString());
            }
            
            // Updated files.
            try {
                Iterator itrUpdated = fileMonitor_.filesUpdated.iterator();
                while(itrUpdated.hasNext()) {
                    SimpleEntry<Entry, File> fileUpdated =
                            (SimpleEntry<Entry, File>)itrUpdated.next();
                    System.out.println("Updating file in dropbox: "
                                        + fileUpdated.toString());
                    db.updateFile(fileUpdated);
                    itrUpdated.remove();
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("Error while removing entry from dropbox: "
                                    + e.toString());
            }
        }
    }
}
