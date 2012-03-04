/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightningrod.io;

import com.dropbox.client2.DropboxAPI.Entry;
import java.io.File;
import java.util.AbstractMap.SimpleEntry;
import java.util.*;

// http://geosoft.no/software/filemonitor/FileMonitor.java.html

public class FileMonitorAdvanced extends FileMonitor implements FileListener {
    private Map<File, Entry> filesToMonitor_;
    private long fileCreationPollingInterval_;
    private final File localDropboxRootDirectory_;
    private Timer timer_;
    public Set<File> filesAdded;
    public Set<Entry> filesRemoved;
    public Set<SimpleEntry<Entry, File> > filesUpdated;
    
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
        localDropboxRootDirectory_ = localDropboxRootDirectory;
        fileCreationPollingInterval_ = fileCreationPollingInterval;
        
        filesToMonitor_ = new HashMap<File, Entry>();
        filesAdded = Collections.synchronizedSet(new LinkedHashSet<File>());
        filesRemoved = Collections.synchronizedSet(new LinkedHashSet<Entry>());
        filesUpdated = Collections.synchronizedSet(
                new LinkedHashSet<SimpleEntry<Entry, File> >());
    }
    
    @Override
    public void startTimer() {
        super.startTimer();
        timer_ = new Timer(true);
        timer_.schedule(new FileCreationNotifier(), 0,
                        fileCreationPollingInterval_);
    }
    
    @Override
    public void stopTimer() {
        super.stopTimer();
        timer_.cancel();
    }
    
    /**
     * Adds a file to monitor for changes and deletion.
     *
     * @param entry Entry in Dropbox that corresponds to file.
     * @param file Local file to monitor for changes and deletion.
     */
    public void addFile (File file, Entry entry) {
        if (file.isHidden()) {
            System.out.println("NOT adding monitoring for hidden file: "
                               + file);
            return;
        }
        
        System.out.println("Adding monitoring for file: " + file);
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
        System.out.println("Removing monitoring for file: " + file);
        filesToMonitor_.remove(file);
        super.removeFile(file);
    }
    
    /**
     * This is the timer thread which is executed every n milliseconds according
     * to the setting of the file monitor. It investigates the file in question
     * and notify listeners if changed.
     */
    private class FileCreationNotifier extends TimerTask {
        // Note that this *will* follow symbolic links. Good luck.
        private Set<File> getAllFiles(File root) {
            Set<File> newFiles = new LinkedHashSet();
            
            File[] files = root.listFiles();
            for (File f : files) {
                newFiles.add(f);
                if (!f.isFile()) {
                    Set<File> subFiles = getAllFiles(f);
                    newFiles.addAll(subFiles);
                }
            }
            
            return newFiles;
        }
        
        @Override
        public void run() {
            // Create a set of all files starting with 
            // localDropboxRootDirectory_. Compare this set with the set of
            // files being monitored. Any files that are new to the set have
            // been added. Notify the appropriate authorities.
            Set<File> filesBeingMonitored = new HashSet(filesToMonitor_.keySet());
            Set<File> filesThatExist = getAllFiles(localDropboxRootDirectory_);
            filesThatExist.removeAll(filesBeingMonitored);
            
            System.out.println("Files added: " + filesThatExist.toString());
            filesAdded.addAll(filesThatExist);
        }
    }
    
    // Note: this will also run on file deletion (timestamp will be set to -1,
    //   making the file "modified". Check to see if the file exists and handle
    //   appropriately.
    @Override
    public void fileChanged (File file) {
        boolean hasDropboxEntry = true;
        Entry entry = filesToMonitor_.get(file);
        if(entry == null) {
            System.out.println("Local file: " + file.getAbsolutePath()
                    + " has no corresponding Dropbox file. No syncing can be"
                    + " performed.");
            hasDropboxEntry = false;
        }
        
        boolean isDeleted = !file.exists();        
        if(isDeleted) {
            System.out.println("File deleted: " + file.getAbsolutePath());
            
            // Stop checking for updates to this file.
            this.removeFile(file);
            // Make sure that if this file was added and then removed that
            // we don't overlap.
            filesAdded.remove(file);
            // Add this entry to the list that should be synced with dropbox
            // by removing them.
            filesRemoved.add(entry);
            if (hasDropboxEntry) {
                System.out.println("=> Corresponding Dropbox path: " + entry.path);
            }
        } else {
            System.out.println("File modified: " + file.getAbsolutePath());
            if (hasDropboxEntry) {
                System.out.println("=> Corresponding Dropbox path: " + entry.path);
                filesUpdated.add(new SimpleEntry<Entry, File> (entry, file));
            }
        }
    }
}
