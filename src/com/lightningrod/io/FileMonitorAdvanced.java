/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightningrod.io;

import com.dropbox.client2.DropboxAPI;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.*;
import no.geosoft.cc.io.FileListener;
import no.geosoft.cc.io.FileMonitor;

// http://geosoft.no/software/filemonitor/FileMonitor.java.html

public class FileMonitorAdvanced extends FileMonitor implements FileListener {
    BiMap<File, DropboxAPI.Entry> filesToMonitor_;
    private final long fileCreationPollingInterval_;
    private final File localDropboxRootDirectory_;
    private Timer timer_;
    
    // fileChangePollingInterval = milliseconds interval between examining
    //   known list of files for changes.
    // fileCreateDeletePollingInterval = milliseconds interval between
    //   examining.
    // localDropboxRootDirectory = a file representing the root directory
    //   of the local Dropbox. This is used to recursively check for file
    //   additions and removals.
    public FileMonitorAdvanced(long fileChangePollingInterval,
                               long fileCreationPollingInterval,
                               File localDropboxRootDirectory) {
        super(fileChangePollingInterval);
        fileCreationPollingInterval_ = fileCreationPollingInterval;
        localDropboxRootDirectory_ = localDropboxRootDirectory;
        
        filesToMonitor_ = HashBiMap.create();
        
        timer_ = new Timer(true);
        timer_.schedule(new FileCreationNotifier(), 0,
                        fileCreationPollingInterval);
    }
    
    /**
     * Adds a file to monitor for changes and deletion.
     *
     * @param entry Entry in Dropbox that corresponds to file.
     * @param file Local file to monitor for changes and deletion.
     */
    public void addFileToMonitor (File file, DropboxAPI.Entry entry) {
        filesToMonitor_.put(file, entry);
        super.addFile(file);
    }
    
    /**
     * Remove specified file for listening.
     *
     * @param file File to remove.
     */
    @Override
    public void removeFile(File file) {
        filesToMonitor_.remove(file);
        super.removeFile(file);
    }
    
    /**
     * This is the timer thread which is executed every n milliseconds according
     * to the setting of the file monitor. It investigates the file in question
     * and notify listeners if changed.
     */
    private class FileCreationNotifier extends TimerTask {

        @Override
        public void run() {
            // Create a set of all files starting with 
            // localDropboxRootDirectory_. Compare this set with the set of
            // files being monitored. Any files that are new to the set have
            // been added. Notify the appropriate authorities.
            Set<File> filesBeingMonitored = new HashSet(filesToMonitor_.keySet());
            Set<File> filesThatExist = new HashSet(filesBeingMonitored.size());
            
            // TODO(ebensh): Recursively add existing files to filesThatExist.
            filesThatExist.removeAll(filesBeingMonitored);
            
            // TODO(ebensh): Add filesThatExist to a *unique* queue of files
            // to be added to Dropbox for Kevin to consume.
        }
    }
    
    // Note: this will also run on file deletion (timestamp will be set to -1,
    //   making the file "modified". Check to see if the file exists and handle
    //   appropriately.
    @Override
    public void fileChanged (File file) {
        boolean hasDropboxEntry = true;
        DropboxAPI.Entry entry = filesToMonitor_.get(file);
        if(entry == null) {
            System.out.println("Local file: " + file.getAbsolutePath()
                    + " has no corresponding Dropbox file. No syncing can be"
                    + " performed.");
            hasDropboxEntry = false;
        }
        
        boolean isDeleted = !file.exists();        
        if(isDeleted) {
            System.out.println("File deleted: " + file.getAbsolutePath());
            if (hasDropboxEntry) {
                System.out.println("=> Corresponding Dropbox path: " + entry.path);
            }
        } else {
            System.out.println("File modified: " + file.getAbsolutePath());
            if (hasDropboxEntry) {
                System.out.println("=> Corresponding Dropbox path: " + entry.path);
            }
        }
    }
}
