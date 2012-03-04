package com.lightningrod.io;

import java.util.HashSet;
import java.util.Set;

public class FileMonitorAdvancedTest {
    public static void main (String args[]) {
        Set<String> s1 = new HashSet<String>();
        Set<String> s2 = new HashSet<String>();
        s1.add("a");
        s1.add("b");
        System.out.println(s1.contains("a"));
        s2.add("a");
        s1.removeAll(s2);
        System.out.println(s1);
        
        /*FileMonitorAdvanced monitor = new FileMonitorAdvanced (3000L, 5000L,
            new File("/home/monk/test_dropbox"));
        DBSync sync = new DBSync(monitor, 3000L);

        monitor.addFile (new File ("/home/monk/test_dropbox/test1"), null);
        monitor.addFile (new File ("/home/monk/test_dropbox/test2"), null);
        monitor.addFile (new File ("/home/monk/test_dropbox/subfolder"), null);

        monitor.addListener (monitor);
        monitor.startTimer();
        sync.startTimer();

        while (true) ;
        //monitor.stopTimer();*/
    }
}