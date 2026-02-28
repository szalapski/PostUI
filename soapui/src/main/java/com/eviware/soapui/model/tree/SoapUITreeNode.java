

package com.eviware.soapui.model.tree;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.action.swing.ActionList;

import javax.swing.JPopupMenu;
import javax.swing.tree.TreeNode;

/**
 * Behaviour for navigator tree nodes
 *
 * @author Ole.Matzura
 */

public interface SoapUITreeNode extends TreeNode {
    public int getChildCount();

    public int getIndexOfChild(Object child);

    public boolean valueChanged(Object newValue);

    public SoapUITreeNode getChildNode(int index);

    public boolean isLeaf();

    public JPopupMenu getPopup();

    public SoapUITreeNode getParentTreeNode();

    public void release();

    public ActionList getActions();

    public void reorder(boolean notify);

    public ModelItem getModelItem();
}
