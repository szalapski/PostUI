

package com.eviware.soapui.support.dnd;

import javax.swing.JComponent;
import javax.swing.JTree;
import java.awt.Component;
import java.awt.Rectangle;

public abstract class JTreeDragAndDropable<T> implements SoapUIDragAndDropable<T> {
    private JTree tree;

    public JTreeDragAndDropable(JTree tree) {
        this.tree = tree;
    }

    public JTree getTree() {
        return tree;
    }

    public Component getCellRendererComponent(Object lastPathComponent, boolean b, boolean object, boolean object2,
                                              int i, boolean c) {
        return tree.getCellRenderer().getTreeCellRendererComponent(tree, lastPathComponent, b, object, object2, i, c);
    }

    public JComponent getComponent() {
        return tree;
    }

    public void setDragInfo(String dropInfo) {
        tree.setToolTipText(dropInfo);
    }

    public Rectangle getModelItemBounds(T path) {
        return tree.getRowBounds(getRowForModelItem(path));
    }

    public T getModelItemForLocation(int x, int y) {
        int rowForLocation = tree.getRowForLocation(x, y);
        if (rowForLocation == -1) {
            rowForLocation = tree.getClosestRowForLocation(x, y);
        }

        return getModelItemAtRow(rowForLocation);
    }

    public void selectModelItem(T path) {
        int row = getRowForModelItem(path);
        tree.setSelectionRow(row);
    }

    public void toggleExpansion(T last) {
        int row = getRowForModelItem(last);
        if (tree.isExpanded(row)) {
            tree.collapseRow(row);
        } else {
            tree.expandRow(row);
        }
    }

    public abstract int getRowForModelItem(T modelItem);

    public abstract T getModelItemAtRow(int row);

}
