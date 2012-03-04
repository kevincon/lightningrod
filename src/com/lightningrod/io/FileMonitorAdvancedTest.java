package com.lightningrod.io;

import java.io.File;

public class FileMonitorAdvancedTest {
    public static void main (String args[]) {
        FileMonitorAdvanced monitor = new FileMonitorAdvanced (1000L, 5000L,
            new File("/home/monk/test_dropbox"));

        monitor.addFile (new File ("/home/monk/test_dropbox/test1"), null);
        monitor.addFile (new File ("/home/monk/test_dropbox/test2"), null);
        monitor.addFile (new File ("/home/monk/test_dropbox/subfolder"), null);

        monitor.addListener (monitor);
        monitor.startTimer();

        while (true) ;
        monitor.stopTimer();
    }
}