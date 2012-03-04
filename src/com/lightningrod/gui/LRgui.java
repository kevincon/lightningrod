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
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;


/**
 * Lightning Rod GUI
 * @author William Etter
 */
public class LRgui extends javax.swing.JFrame {

    /**
     * Class that carries out mouse actions
     */
    class DBNodeMouseListener extends MouseAdapter {
        JTree mousetree;
    
        DBNodeMouseListener(JTree tree){
            this.mousetree = tree;
        }
    
        public void mouseClicked(MouseEvent mevent) {
            int x = mevent.getX();
            int y = mevent.getY();
            int treerow = mousetree.getRowForLocation(x, y);
            TreePath  path = mousetree.getPathForRow(treerow);
            if (path != null) {
                DBNode node = (DBNode)path.getLastPathComponent();
                boolean isSelected = ! (node.isSelected());
                node.setSelected(isSelected);
                
                // Check if node is directory
                if(node.childrenAllowed()){
                    // If selected expand, otherwise contract
                    if(isSelected){
                        mousetree.expandPath(path);
                    }else{
                        mousetree.collapsePath(path);
                    }
                }
                                    
                ((DefaultTreeModel) mousetree.getModel()).nodeChanged(node);
                if (treerow == 0) {
                    mousetree.revalidate();
                    mousetree.repaint();
                } 
            }
        }
    }

    /*
  class ModePanel extends JPanel implements ActionListener {
    CheckNode[] nodes;

    JRadioButton b_single, b_dig_in;

    ModePanel(CheckNode[] nodes) {
      this.nodes = nodes;
      setLayout(new GridLayout(2, 1));
      setBorder(new TitledBorder("Check Mode"));
      ButtonGroup group = new ButtonGroup();
      add(b_dig_in = new JRadioButton("DIG_IN  "));
      add(b_single = new JRadioButton("SINGLE  "));
      group.add(b_dig_in);
      group.add(b_single);
      b_dig_in.addActionListener(this);
      b_single.addActionListener(this);
      b_dig_in.setSelected(true);
    }

    public void actionPerformed(ActionEvent e) {
      int mode;
      if (b_single == e.getSource()) {
        mode = CheckNode.SINGLE_SELECTION;
      } else {
        mode = CheckNode.DIG_IN_SELECTION;
      }
      for (int i = 0; i < nodes.length; i++) {
        nodes[i].setSelectionMode(mode);
      }
    }
  }

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

  public static void main(String args[]) {
    try {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception evt) {}
  
    CheckNodeTreeExample frame = new CheckNodeTreeExample();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}
     */
    
    
    
    
    
    
    
    
    /**
     * Creates new form LRgui
     */
    public LRgui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        filejTree = new javax.swing.JTree();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jProgressBar1.setMaximumSize(new java.awt.Dimension(32767, 70));
        jProgressBar1.setMinimumSize(new java.awt.Dimension(20, 40));
        jProgressBar1.setPreferredSize(new java.awt.Dimension(200, 70));
        jProgressBar1.setRequestFocusEnabled(false);
        jProgressBar1.setSize(new java.awt.Dimension(146, 70));

        jScrollPane1.setViewportView(filejTree);

        jScrollPane2.setViewportView(jScrollPane1);

        jMenu1.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

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
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(0, 386, Short.MAX_VALUE)
                        .add(jProgressBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 264, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(228, 228, 228))
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 381, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jProgressBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 362, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // CHECK FOR FINISHING TRANSFERS BEFORE CLOSE
        System.exit(0);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
        String[] strs = {"swing",     // 0
         "platf",     // 1
         "basic",     // 2
         "metal",     // 3
         "JTree"};    // 4
        
        
        DBNode[] nodes = new DBNode[strs.length];
        for (int i=0;i<strs.length;i++) {
            nodes[i] = new DBNode(strs[i]); 
        }
        nodes[0].add(nodes[1]);
        nodes[1].add(nodes[2]);
        nodes[1].add(nodes[3]);
        nodes[0].add(nodes[4]);
        nodes[3].setSelected(true);
        
        JTree filetree = new JTree( nodes[0] );
        
        
        filetree.setCellRenderer(new CheckRenderer());
        filetree.getSelectionModel().setSelectionMode(
        TreeSelectionModel.SINGLE_TREE_SELECTION
        );
        tree.putClientProperty("JTree.lineStyle", "Angled");
        tree.addMouseListener(new NodeSelectionListener(tree));
        JScrollPane sp = new JScrollPane(tree);

        ModePanel mp = new ModePanel(nodes);
        JTextArea textArea = new JTextArea(3,10);
        JScrollPane textPanel = new JScrollPane(textArea);
        JButton button = new JButton("print");
        button.addActionListener(
        new ButtonActionListener(nodes[0], textArea));
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(mp,     BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        
  

        /*
         * Create and display the form
         */
        // <editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LRgui().setVisible(true);
            }
        });
        // </editor-fold>
    }   // END MAIN METHOD     
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree filejTree;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}   // END CLASS LRgui


//************************************************************//


/**
 * A class that defines a Node in the DropBox File Structure
 * The node object is the DropBox Entry Object
 * @author William Etter
 */
class DBNode extends DefaultMutableTreeNode {
    // <editor-fold>
    protected boolean isDirectory;  // Is the node a Directory?
    protected boolean isSelected;   // Is the node selected?    
    
    /*
     ********** CONSTRUCTORS ************
    */
    public DBNode() {
        this(null);
        // Should never go here
        System.out.println("Tried constructing DBNode without Entry Data.");
    }

    public DBNode(Object dbEntry) {
        super(dbEntry,((DropboxAPI.Entry)dbEntry).isDir);
        
        DropboxAPI.Entry entry = (DropboxAPI.Entry)dbEntry;
        
        // Determine if parent is selected
        if(!((DropboxAPI.Entry)dbEntry).isDir){
            // Not a directory
            if(((DBNode)(this.getParent())).isSelected()){
                    // Parent is selectd, also set this node as selected
                    this.isSelected = true;
            }else{
                // Parent is not selected
                this.isSelected = false;
            }
        }
    }

    /*
    *   Set the node selection.  If a directory, set all children as selected
    *   recursively.
    */
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
        if (children != null) {
            Enumeration e = children.elements();
            while (e.hasMoreElements()) {
                DBNode node = (DBNode) e.nextElement();
                node.setSelected(isSelected);
            }
        }
    }
    
    /*
    *   Returns whether the node is selected or not.
    */
    public boolean isSelected() {
        return isSelected;
    }
    
    /*
     *  Returns whether the node allows children or not.
     */
    public boolean childrenAllowed(){
        return this.allowsChildren;
    }
    
    /*
    *   Overrides the DefaultMutableTreeNode toString method for use when
    *   displaying file structure
    */
    public String toString(){
        return ((DropboxAPI.Entry)this.getUserObject()).fileName();
    }
    // </editor-fold>
}   // END CLASS DBnode





/*



class CheckRenderer extends JPanel implements TreeCellRenderer {
  protected JCheckBox check;

  protected TreeLabel label;

  public CheckRenderer() {
    setLayout(null);
    add(check = new JCheckBox());
    add(label = new TreeLabel());
    check.setBackground(UIManager.getColor("Tree.textBackground"));
    label.setForeground(UIManager.getColor("Tree.textForeground"));
  }

  public Component getTreeCellRendererComponent(JTree tree, Object value,
      boolean isSelected, boolean expanded, boolean leaf, int row,
      boolean hasFocus) {
    String stringValue = tree.convertValueToText(value, isSelected,
        expanded, leaf, row, hasFocus);
    setEnabled(tree.isEnabled());
    check.setSelected(((CheckNode) value).isSelected());
    label.setFont(tree.getFont());
    label.setText(stringValue);
    label.setSelected(isSelected);
    label.setFocus(hasFocus);
    if (leaf) {
      label.setIcon(UIManager.getIcon("Tree.leafIcon"));
    } else if (expanded) {
      label.setIcon(UIManager.getIcon("Tree.openIcon"));
    } else {
      label.setIcon(UIManager.getIcon("Tree.closedIcon"));
    }
    return this;
  }

  public Dimension getPreferredSize() {
    Dimension d_check = check.getPreferredSize();
    Dimension d_label = label.getPreferredSize();
    return new Dimension(d_check.width + d_label.width,
        (d_check.height < d_label.height ? d_label.height
            : d_check.height));
  }

  public void doLayout() {
    Dimension d_check = check.getPreferredSize();
    Dimension d_label = label.getPreferredSize();
    int y_check = 0;
    int y_label = 0;
    if (d_check.height < d_label.height) {
      y_check = (d_label.height - d_check.height) / 2;
    } else {
      y_label = (d_check.height - d_label.height) / 2;
    }
    check.setLocation(0, y_check);
    check.setBounds(0, y_check, d_check.width, d_check.height);
    label.setLocation(d_check.width, y_label);
    label.setBounds(d_check.width, y_label, d_label.width, d_label.height);
  }

  public void setBackground(Color color) {
    if (color instanceof ColorUIResource)
      color = null;
    super.setBackground(color);
  }

  public class TreeLabel extends JLabel {
    boolean isSelected;

    boolean hasFocus;

    public TreeLabel() {
    }

    public void setBackground(Color color) {
      if (color instanceof ColorUIResource)
        color = null;
      super.setBackground(color);
    }

    public void paint(Graphics g) {
      String str;
      if ((str = getText()) != null) {
        if (0 < str.length()) {
          if (isSelected) {
            g.setColor(UIManager
                .getColor("Tree.selectionBackground"));
          } else {
            g.setColor(UIManager.getColor("Tree.textBackground"));
          }
          Dimension d = getPreferredSize();
          int imageOffset = 0;
          Icon currentI = getIcon();
          if (currentI != null) {
            imageOffset = currentI.getIconWidth()
                + Math.max(0, getIconTextGap() - 1);
          }
          g.fillRect(imageOffset, 0, d.width - 1 - imageOffset,
              d.height);
          if (hasFocus) {
            g.setColor(UIManager
                .getColor("Tree.selectionBorderColor"));
            g.drawRect(imageOffset, 0, d.width - 1 - imageOffset,
                d.height - 1);
          }
        }
      }
      super.paint(g);
    }

    public Dimension getPreferredSize() {
      Dimension retDimension = super.getPreferredSize();
      if (retDimension != null) {
        retDimension = new Dimension(retDimension.width + 3,
            retDimension.height);
      }
      return retDimension;
    }

    public void setSelected(boolean isSelected) {
      this.isSelected = isSelected;
    }

    public void setFocus(boolean hasFocus) {
      this.hasFocus = hasFocus;
    }
  }
}


 */