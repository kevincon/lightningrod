/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightningrod.gui;

import com.dropbox.client2.DropboxAPI;
import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;

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