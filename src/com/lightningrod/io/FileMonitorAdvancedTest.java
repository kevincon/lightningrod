package com.lightningrod.io;

import java.io.File;

public class FileMonitorAdvancedTest {
    public static void main (String args[]) {
        FileMonitorAdvanced monitor = new FileMonitorAdvanced (1000);

        monitor.addFile (new File ("/home/monk/test_dropbox/test1"));
        monitor.addFile (new File ("/home/monk/test_dropbox/test2"));
        monitor.addFile (new File ("/home/monk/test_dropbox/subfolder"));

        monitor.addListener (new FileModHandler());

        while (true) ;
    }
}