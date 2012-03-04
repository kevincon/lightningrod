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
//import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author bill
 */
public class LRgui extends javax.swing.JFrame {
    // Selection Set
    static HashSet <DropboxAPI.Entry>s1 = new HashSet <DropboxAPI.Entry>();
    // Deletion Set
    static HashSet <DropboxAPI.Entry>s2 = new HashSet <DropboxAPI.Entry>();
    
    //static JTree filetree = new JTree((TreeNode)null);
    //static DBNode rootnode = com.lightningrod.dropbox.DBApi.treeDir(null);
    
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
                                    
                ((DefaultTreeModel) mousetree.getModel()).nodeChanged(node);
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
    
    public int collapseNode (JTree tree,DBNode node, int row){
            if (node != null  &&  !node.isLeaf()) {
                tree.collapseRow(row);
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
                    row = collapseNode(tree, child, row);
                }
            }   
            return row;
        }
    

    /**
     * Creates new form gui
     */
    public LRgui() {
        initComponents();
        
        /******* NEW CODE ********/
        
        // Set Root Node as invisible
        filetreedisplay.setRootVisible(false);
        filetreedisplay.setCellRenderer(new RenderChecks());
        filetreedisplay.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        filetreedisplay.putClientProperty("JTree.lineStyle", "Angled");
        filetreedisplay.addMouseListener(new DBNodeMouseListener(filetreedisplay));
        JTextArea textArea = new JTextArea(3,10);
        JScrollPane textPanel = new JScrollPane(textArea);
        JButton button = new JButton("print");
        
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

        updateFiles.setText("Update File List");
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
        syncstatusBar.setSize(new java.awt.Dimension(146, 40));

        syncStatus.setText("Sync/Update Status");

        usbspaceBar.setMaximumSize(new java.awt.Dimension(32767, 40));
        usbspaceBar.setMinimumSize(new java.awt.Dimension(10, 40));
        usbspaceBar.setPreferredSize(new java.awt.Dimension(146, 40));
        usbspaceBar.setSize(new java.awt.Dimension(146, 40));

        usbStatus.setText("USB Storage");

        dbspaceBar.setMaximumSize(new java.awt.Dimension(32767, 40));
        dbspaceBar.setMinimumSize(new java.awt.Dimension(10, 40));
        dbspaceBar.setPreferredSize(new java.awt.Dimension(146, 40));
        dbspaceBar.setSize(new java.awt.Dimension(146, 40));

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
                        .add(updateFiles)))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(infoText)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                    .add(syncStatus)
                                    .add(48, 48, 48))
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                    .add(usbStatus)
                                    .add(70, 70, 70))
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                    .add(dbStatus)
                                    .add(69, 69, 69)))))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(usbspaceBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 186, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(syncstatusBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 186, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(dbspaceBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 186, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(19, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(syncstatusBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(19, 19, 19)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(selectAll)
                            .add(deselectAll)
                            .add(updateFiles))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(filedisplayPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 381, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(syncStatus)
                        .add(38, 38, 38)
                        .add(usbspaceBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(usbStatus)
                        .add(27, 27, 27)
                        .add(dbspaceBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(dbStatus)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(infoText)
                        .add(62, 62, 62))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        // CHECK FOR FINISHING TRANSFERS BEFORE CLOSE
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

    private void updateFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateFilesActionPerformed
        // TODO add your handling code here:
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
        int dummy = collapseNode(filetreedisplay,rootnode,-1);
        
        ((DefaultTreeModel) filetreedisplay.getModel()).nodeChanged(rootnode);
        filetreedisplay.revalidate();
        filetreedisplay.repaint();
    }//GEN-LAST:event_deselectAllActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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

        // Set Variables
        
        // Set Root Node as Selected
        rootnode.setRootSelected();
        
        
        // TEST TEST TEST
        
        
        DropboxAPI.Entry entry1 = new DropboxAPI.Entry();
        entry1.path = "test1";
        com.lightningrod.gui.DBNode e1 = new com.lightningrod.gui.DBNode(entry1,true);
        
        DropboxAPI.Entry entry2 = new DropboxAPI.Entry();
        entry2.path = "ab";
        com.lightningrod.gui.DBNode e2 = new com.lightningrod.gui.DBNode(entry2);
        
        DropboxAPI.Entry entry3 = new DropboxAPI.Entry();
        entry3.path = "test3";
        com.lightningrod.gui.DBNode e3 = new com.lightningrod.gui.DBNode(entry3);
        
        DropboxAPI.Entry entry4 = new DropboxAPI.Entry();
        entry4.path = "a";
        com.lightningrod.gui.DBNode e4 = new com.lightningrod.gui.DBNode(entry4,true);
        
        DropboxAPI.Entry entry5 = new DropboxAPI.Entry();
        entry5.path = "a";
        com.lightningrod.gui.DBNode e5 = new com.lightningrod.gui.DBNode(entry5);
        
        DropboxAPI.Entry entry6 = new DropboxAPI.Entry();
        entry6.path = "best6";
        com.lightningrod.gui.DBNode e6 = new com.lightningrod.gui.DBNode(entry6,true);
        
        DropboxAPI.Entry entry7 = new DropboxAPI.Entry();
        entry7.path = "best7";
        com.lightningrod.gui.DBNode e7 = new com.lightningrod.gui.DBNode(entry7,true);
        
        DropboxAPI.Entry entry8 = new DropboxAPI.Entry();
        entry8.path = "best8";
        com.lightningrod.gui.DBNode e8 = new com.lightningrod.gui.DBNode(entry8);
        
        DropboxAPI.Entry root = new DropboxAPI.Entry();
        root.path = "testr";
        rootnode.setUserObject(root);
        //com.lightningrod.gui.DBNode r = new com.lightningrod.gui.DBNode(root);
        
        rootnode.add(e6);
        
        e1.add(e3);
        rootnode.add(e2);
        rootnode.add(e1);
        rootnode.add(e4);
        e4.add(e5);
        e6.add(e7);
        e7.add(e8);
        
        // TEST TEST TEST END
        
        
        

        
        
        
        
       
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            // <editor-fold>
            @Override
            public void run() {
                new LRgui().setVisible(true);
            }
        });
        // </editor-fold>
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dbStatus;
    private javax.swing.JProgressBar dbspaceBar;
    private javax.swing.JButton deselectAll;
    private javax.swing.JScrollPane filedisplayPane;
    private javax.swing.JTree filetreedisplay;
    private javax.swing.JLabel infoText;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JButton selectAll;
    private javax.swing.JLabel syncStatus;
    private javax.swing.JProgressBar syncstatusBar;
    private javax.swing.JButton updateFiles;
    private javax.swing.JLabel usbStatus;
    private javax.swing.JProgressBar usbspaceBar;
    // End of variables declaration//GEN-END:variables
}

/*




  class ButtonActionListener implements ActionListener {
    CheckNode root;

    JTextArea textArea;

    ButtonActionListener(final CheckNode root, final JTextArea textArea) {
      this.root = root;
      this.textArea = textArea;
    }

    public void actionPerformed(ActionEvent ev) {
      Enumeration e = root.breadthFirstEnumeration();
      while (e.hasMoreElements()) {
        CheckNode node = (CheckNode) e.nextElement();
        if (node.isSelected()) {
          TreeNode[] nodes = node.getPath();
          textArea.append("\n" + nodes[0].toString());
          for (int i = 1; i < nodes.length; i++) {
            textArea.append("/" + nodes[i].toString());
          }
        }
      }
    }
  }

  
}



 */