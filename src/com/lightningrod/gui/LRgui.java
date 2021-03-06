/*
 * Lightning Rod - DropBox USB-Based Cloud Syncing Program
 * Lightning Rod GUI - Java GUI Application
 * Evan Benshetler, Mike Chen, Casey Conley, Kevin Conley, William Etter
 */
// Package Name
package com.lightningrod.gui;

// Import Dependencies
import com.dropbox.client2.DropboxAPI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import com.lightningrod.dropbox.DBApi;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.tree.*;
//import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author bill
 */
public class LRgui extends javax.swing.JFrame {
    // Old Set
    static HashSet <String>oldset = new HashSet <String>();
    // New Set
    static HashSet <String>newset = new HashSet <String>();
    
    // Selection Set
    static HashSet <String>sel = new HashSet <String>();
    // Deletion Set
    static HashSet <String>del = new HashSet <String>();
    
    // String HashSet
    static HashSet <String>paths = new HashSet <String>();
    static HashSet <String>oldpaths = new HashSet <String>();
    
    static DBApi dbapiobject;
    
    //static JTree filetree = new JTree((TreeNode)null);
    static DBNode rootnode;// = com.lightningrod.dropbox.DBApi.treeDir(null);
    
    static private int counter = 0;
    static private int hashsize = 0;
    
    /*
     * Class that carries out mouse actions
     */
    class DBNodeMouseListener extends MouseAdapter {
        JTree mousetree;
    
        DBNodeMouseListener(JTree tree){
            this.mousetree = tree;
        }
    
        @Override
        public void mouseClicked(MouseEvent mevent) {
            int x = mevent.getX();
            int y = mevent.getY();
            int treerow = mousetree.getRowForLocation(x, y);
            TreePath  path = mousetree.getPathForRow(treerow);
            if (path != null) {
                DBNode node = (DBNode)path.getLastPathComponent();
                boolean isSelected = !(node.isSelected());
                node.setSelected(isSelected);
                
                System.out.println("CLICKED: " + node.toString() + " " + isSelected);
                
                // Check if node is directory
                if(node.childrenAllowed()){
                    // If selected expand, otherwise contract
                    if(isSelected){
                        //mousetree.expandPath(path);
                        //expandChildren(node,path);
                        int z = expandNode(mousetree,node,treerow);
                    }else{
                        mousetree.collapsePath(path);
                    }
                }
                                    
                ((DefaultTreeModel) mousetree.getModel()).nodeChanged(rootnode);
                mousetree.revalidate();
                mousetree.repaint();
            }
        }
    }
    
    public int expandNode (JTree tree,DBNode node, int row){
            if (node != null  &&  !node.isLeaf()) {
                tree.expandRow(row);
                for (int index = 0; row + 1 < tree.getRowCount() && index < node.getChildCount();index++){
                    row++;
                    DBNode child = (DBNode)node.getChildAt(index);
                    if (child == null)
                        break;
                    TreePath path;
                    while ((path = tree.getPathForRow(row)) != null  &&
                            path.getLastPathComponent() != child)
                        row++;
                    if (path == null)
                        break;
                    row = expandNode(tree, child, row);
                }
            }   
            return row;
        }
    
    
    public void collapseNodes() {
        int row = filetreedisplay.getRowCount() - 1;
        while (row >= 0) {
            filetreedisplay.collapseRow(row);
            row--;
        }
    }
    
    public static void display_dialog(String input){
        JTextArea textArea = new JTextArea(3,10);
        JScrollPane textPanel = new JScrollPane(textArea);
        JButton button = new JButton("print");
        JOptionPane.showMessageDialog(null,
            input,
            "Lightning Rod",
            JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    
    
    public static void initializeTree(){
        //download entire Dropbox folder, add file monitors
        rootnode = dbapiobject.treeDir(dbapiobject.getRoot());
        
        // Set Root Node as Selected
        rootnode.setRootSelected();
        
        DefaultTreeModel treemodel = new DefaultTreeModel(rootnode);
        filetreedisplay.setModel(treemodel);
        filetreedisplay.revalidate();
        filetreedisplay.repaint();
    }
    
    
    /**
     * Creates new gui
     */
    public LRgui() {
        initComponents();
        syncstatusBar.setValue(0);
        usbspaceBar.setValue(dbapiobject.getRootFreeSpace());
        dbspaceBar.setValue(dbapiobject.getDropboxFreeSpace());
        
        /******* NEW CODE ********/
        // Set Root Node as invisible
        filetreedisplay.setRootVisible(false);
        filetreedisplay.setCellRenderer(new RenderChecks());
        filetreedisplay.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        filetreedisplay.putClientProperty("JTree.lineStyle", "Angled");
        filetreedisplay.addMouseListener(new DBNodeMouseListener(filetreedisplay));
        
        
        /** END NEW CODE **/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filedisplayPane = new javax.swing.JScrollPane();
        filetreedisplay = new javax.swing.JTree(rootnode);
        updateFiles = new javax.swing.JButton();
        selectAll = new javax.swing.JButton();
        deselectAll = new javax.swing.JButton();
        syncstatusBar = new javax.swing.JProgressBar();
        syncStatus = new javax.swing.JLabel();
        usbspaceBar = new javax.swing.JProgressBar();
        usbStatus = new javax.swing.JLabel();
        dbspaceBar = new javax.swing.JProgressBar();
        dbStatus = new javax.swing.JLabel();
        infoText = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        filedisplayPane.setViewportView(filetreedisplay);

        updateFiles.setBackground(new java.awt.Color(0, 204, 0));
        updateFiles.setText("SYNC!");
        updateFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateFilesActionPerformed(evt);
            }
        });

        selectAll.setText("Select All");
        selectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllActionPerformed(evt);
            }
        });

        deselectAll.setText("Deselect All");
        deselectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deselectAllActionPerformed(evt);
            }
        });

        syncstatusBar.setMaximumSize(new java.awt.Dimension(32767, 40));
        syncstatusBar.setMinimumSize(new java.awt.Dimension(10, 40));
        syncstatusBar.setPreferredSize(new java.awt.Dimension(146, 40));

        syncStatus.setText("Sync/Update Status");

        usbspaceBar.setBackground(new java.awt.Color(0, 0, 255));
        usbspaceBar.setMaximumSize(new java.awt.Dimension(32767, 40));
        usbspaceBar.setMinimumSize(new java.awt.Dimension(10, 40));
        usbspaceBar.setPreferredSize(new java.awt.Dimension(146, 40));

        usbStatus.setText("USB Storage");

        dbspaceBar.setMaximumSize(new java.awt.Dimension(32767, 40));
        dbspaceBar.setMinimumSize(new java.awt.Dimension(10, 40));
        dbspaceBar.setPreferredSize(new java.awt.Dimension(146, 40));

        dbStatus.setText("DropBox Storage");

        infoText.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        infoText.setText("Lightning Rod");

        jMenu1.setText("File");

        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(layout.createSequentialGroup()
                            .addContainerGap()
                            .add(filedisplayPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 443, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(layout.createSequentialGroup()
                            .add(41, 41, 41)
                            .add(selectAll)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(deselectAll)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(updateFiles, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(28, 28, 28)
                        .add(syncStatus)
                        .add(18, 18, 18)
                        .add(syncstatusBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 186, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(0, 43, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(dbStatus)
                            .add(infoText))
                        .add(53, 53, 53))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(usbspaceBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 186, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(layout.createSequentialGroup()
                                    .add(dbspaceBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 186, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(15, 15, 15)))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(usbStatus)
                                .add(76, 76, 76))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(selectAll)
                            .add(deselectAll)
                            .add(updateFiles, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(13, 13, 13)
                        .add(filedisplayPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 381, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(syncstatusBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 8, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(17, 17, 17)
                                .add(syncStatus)
                                .add(0, 0, Short.MAX_VALUE))))
                    .add(layout.createSequentialGroup()
                        .add(usbspaceBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(usbStatus)
                        .add(68, 68, 68)
                        .add(dbspaceBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(dbStatus)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(infoText)
                        .add(113, 113, 113))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        // CHECK FOR FINISHING TRANSFERS BEFORE CLOSE
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

    private void updateFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateFilesActionPerformed

        Enumeration e = rootnode.breadthFirstEnumeration();
        boolean added;
        while (e.hasMoreElements()) {
            DBNode node = (DBNode) e.nextElement();
            //System.out.println("HERE: " + node.toString() + " " + node.isSelected);
            if (node.isSelected() && !node.isRoot()) {
                newset.add(((DropboxAPI.Entry)(node.getUserObject())).path);
            }
        }
        
        // PRINT
        //System.out.println("Newset = "+newset);
        
        // Update SEL and DEL hashsets
        sel.addAll(newset);
        sel.removeAll(oldset);
        del.addAll(oldset);
        del.removeAll(newset);
        
        System.out.println("Sel = "+sel);
        System.out.println("Del = "+del);
        
        // Set OLD set to NEW set and clear newset
        oldset.clear();
        oldset.addAll(newset);
        newset.clear();
        //System.out.println("Oldset = "+oldset);
        //System.out.println("Newset = "+newset);
        
        // Update Previous Selection Paths Hashset
        Iterator<String> iter = oldset.iterator();
        while(iter.hasNext()){
            paths.add(iter.next());
        }
        
        // Update DBApi Hashset
        paths.addAll(dbapiobject.pathnames);
        // Clear DBApi Paths HashSet
        dbapiobject.pathnames.clear();
        
        // Update Tree and Add Selections
        rootnode = dbapiobject.treeDir(dbapiobject.getRoot());
        DefaultTreeModel treemodel = new DefaultTreeModel(rootnode);
        filetreedisplay.setModel(treemodel);
        
        // Set Root Node as Selected
        rootnode.setRootSelected();
        
        // Size of Hashset for adding
        hashsize = sel.size() + del.size();
        
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    // Pause 1000 ms
                    int val = 0;
                    if(hashsize > 0)
                        val = (int)((100*((double)counter/(double)hashsize)));
                    System.out.println(val);
                    syncstatusBar.setValue(val);
                    syncstatusBar.revalidate();
                    syncstatusBar.repaint();
                    usbspaceBar.setValue(dbapiobject.getRootFreeSpace());
                    dbspaceBar.setValue(dbapiobject.getDropboxFreeSpace());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LRgui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if (val == 100) {
                        return;
                    }
                }
            }
        }).start();
        
        // Iterate through tree and check if pathname is in Hashset
        e = rootnode.breadthFirstEnumeration();
        counter = 0;
        while (e.hasMoreElements()) {
            this.validate();
            this.repaint();
            DBNode node = (DBNode) e.nextElement();
            DropboxAPI.Entry entry = (DropboxAPI.Entry)(node.getUserObject());
            String pathval = entry.path;
            // Check pathname
            if(del.contains(pathval)){
                // Uncheck and delete local file
                System.out.println("GOT THERE WITH "+node.toString());
                node.setSelected(false);
                dbapiobject.deleteLocalFile(entry);
                counter++;
            }
            else if((paths.contains(pathval) && (!sel.contains(pathval)))){
                // Only set node as selected
                node.setSelectedStupid();
            }else if(sel.contains(pathval)){
                // Download and set as selected
                dbapiobject.downloadFile(entry);
                node.setSelectedStupid();
                counter++;
            }
        }
        
        // Update CheckBoxes
        ((DefaultTreeModel) filetreedisplay.getModel()).nodeChanged(rootnode);
        int dummy = expandNode(filetreedisplay,rootnode,-1);
        filetreedisplay.revalidate();
        filetreedisplay.repaint();
        
        // Update Status Bars
        /*
        syncstatusBar.revalidate();
        usbspaceBar.revalidate();
        dbspaceBar.revalidate();
        syncstatusBar.repaint();
        usbspaceBar.repaint();
        dbspaceBar.repaint();
        */
    }//GEN-LAST:event_updateFilesActionPerformed

    private void selectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllActionPerformed
        // Select ALL nodes
        if(rootnode.children() != null){
            Enumeration e = rootnode.children();
            while (e.hasMoreElements()) {
                DBNode node = (DBNode) e.nextElement();
                node.setSelected(true);
            }
        }
        // Expand Tree
        int dummy = expandNode(filetreedisplay,rootnode,-1);
        
        ((DefaultTreeModel) filetreedisplay.getModel()).nodeChanged(rootnode);
        filetreedisplay.revalidate();
        filetreedisplay.repaint();
    }//GEN-LAST:event_selectAllActionPerformed

    private void deselectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deselectAllActionPerformed
        // Deelect ALL nodes
        if(rootnode.children() != null){
            Enumeration e = rootnode.children();
            while (e.hasMoreElements()) {
                DBNode node = (DBNode) e.nextElement();
                node.setSelected(false);
            }
        }
        // Contract Tree
        collapseNodes();//(filetreedisplay,rootnode,0);
        
        ((DefaultTreeModel) filetreedisplay.getModel()).nodeChanged(rootnode);
        filetreedisplay.revalidate();
        filetreedisplay.repaint();
    }//GEN-LAST:event_deselectAllActionPerformed

    
    public static void setupGUI(DBApi db){
        // <editor-fold>
        
        oldset.clear();
        newset.clear();
        paths.clear();
        sel.clear();
        del.clear();
        
        dbapiobject = db;
        
        
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LRgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LRgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LRgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LRgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LRgui().setVisible(true);
            }
        });
        // Reset statusbars
        //resetBars();
    }// </editor-fold>
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dbStatus;
    private static javax.swing.JProgressBar dbspaceBar;
    private javax.swing.JButton deselectAll;
    private javax.swing.JScrollPane filedisplayPane;
    private static javax.swing.JTree filetreedisplay;
    private javax.swing.JLabel infoText;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JButton selectAll;
    private javax.swing.JLabel syncStatus;
    private static javax.swing.JProgressBar syncstatusBar;
    private javax.swing.JButton updateFiles;
    private javax.swing.JLabel usbStatus;
    private static javax.swing.JProgressBar usbspaceBar;
    // End of variables declaration//GEN-END:variables
}