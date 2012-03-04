/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightningrod.dropbox;

import com.lightningrod.io.FileMonitorAdvanced;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TimerTask;

/**
 *
 * @author monk
 */
public class DBSync {
    private final FileMonitorAdvanced fileMonitor_;

    public DBSync(FileMonitorAdvanced fileMonitor) {
        fileMonitor_ = fileMonitor;
    }
    
    private class DBSyncTimer extends TimerTask {
        @Override
        public void run() {
            fileMonitor_.filesAdded;
            fileMonitor_.filesRemoved;
            fileMonitor_.filesUpdated;
            
            // Kick off a thread to do the adding / removing / updating?
        }
    }
}
