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
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
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
    static DBNode rootnode = new DBNode();
    
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
                        expandChildren(node,path);
                    }else{
                        mousetree.collapsePath(path);
                    }
                }
                                    
                ((DefaultTreeModel) mousetree.getModel()).nodeChanged(node);
                //if (treerow == 0) {
                    mousetree.revalidate();
                    mousetree.repaint();
                //} 
            }
        }
        
        public void expandChildren(DBNode n, TreePath orig){
            TreePath expandpath;
            if (n.children() != null) {
                Enumeration e = n.children();
                while (e.hasMoreElements()) {
                    DBNode node = (DBNode) e.nextElement();
                    expandpath = orig.pathByAddingChild((Object)node);
                    if(node.childrenAllowed()){
                        expandChildren(node,expandpath);
                    }else{
                        mousetree.expandPath(expandpath);
                    }
                    //mousetree.expandPath(expandpath);
                }
            }
                
            /*
             * for (int i = 0; i < jTree.getRowCount(); i++) {
            jTree.expandRow(i);
}
             */
            
            
            
            /*
            TreePath expandpath;
            if (n.children() != null) {
                Enumeration e = n.children();
                while (e.hasMoreElements()) {
                    DBNode node = (DBNode) e.nextElement();
                    if(node.childrenAllowed()){
                        expandChildren(node,orig);
                    }else{
                        expandpath = orig.pathByAddingChild((Object)node);
                        mousetree.expandPath(expandpath);
                    }
                }
            }
            *
            */
            //mousetree.expandPath(orig);
        }
    }

    /**
     * Creates new form gui
     */
    public LRgui() {
        initComponents();
        
        // * NEW CODE */
        filetreedisplay.setCellRenderer(new RenderChecks());
        
        filetreedisplay.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        filetreedisplay.putClientProperty("JTree.lineStyle", "Angled");
        filetreedisplay.addMouseListener(new DBNodeMouseListener(filetreedisplay));
        //JScrollPane sp = new JScrollPane(filetreedisplay);

        
        JTextArea textArea = new JTextArea(3,10);
        JScrollPane textPanel = new JScrollPane(textArea);
        JButton button = new JButton("print");
        //button.addActionListener(
        //new ButtonActionListener(nodes[0], textArea));
        //JPanel panel = new JPanel(new BorderLayout());
        //panel.add(button, BorderLayout.SOUTH);

        //getContentPane().add(sp,    BorderLayout.CENTER);
        //getContentPane().add(panel, BorderLayout.EAST);
        //getContentPane().add(textPanel, BorderLayout.SOUTH);
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
                .addContainerGap()
                .add(filedisplayPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 443, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(45, 45, 45)
                .add(updateFiles)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(54, 54, 54)
                        .add(filedisplayPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 381, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(31, 31, 31)
                        .add(updateFiles)))
                .addContainerGap(376, Short.MAX_VALUE))
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
        com.lightningrod.gui.DBNode e6 = new com.lightningrod.gui.DBNode(entry6);
        
        DropboxAPI.Entry root = new DropboxAPI.Entry();
        root.path = "testr";
        rootnode.setUserObject(root);
        //com.lightningrod.gui.DBNode r = new com.lightningrod.gui.DBNode(root);
        
        rootnode.add(e6);
        
        e1.add(e3);
        rootnode.add(e2);
        //e1.add(e3);
        rootnode.add(e1);
        rootnode.add(e4);
        //rootnode.add(e1);
        e4.add(e5);
        
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
    private javax.swing.JScrollPane filedisplayPane;
    private javax.swing.JTree filetreedisplay;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JButton updateFiles;
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