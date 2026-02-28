

package com.eviware.soapui.support.dnd;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.tree.SoapUITreeNode;

import javax.swing.JTree;
import javax.swing.tree.TreePath;
import java.awt.Component;

public class NavigatorDragAndDropable extends JTreeDragAndDropable<ModelItem> {
    public NavigatorDragAndDropable(JTree tree) {
        super(tree);
    }

    @Override
    public ModelItem getModelItemAtRow(int row) {
        TreePath pathForRow = getTree().getPathForRow(row);
        return pathForRow == null ? null : ((SoapUITreeNode) pathForRow.getLastPathComponent()).getModelItem();
    }

    @Override
    public int getRowForModelItem(ModelItem modelItem) {
        if (modelItem == null) {
            return -1;
        }

        TreePath treePath = SoapUI.getNavigator().getTreePath(modelItem);
        return getTree().getRowForPath(treePath);
    }

    public Component getRenderer(ModelItem modelItem) {
        TreePath treePath = SoapUI.getNavigator().getTreePath(modelItem);
        int row = getTree().getRowForPath(treePath);
        SoapUITreeNode treeNode = (SoapUITreeNode) treePath.getLastPathComponent();

        return getTree().getCellRenderer().getTreeCellRendererComponent(getTree(), treeNode, true,
                getTree().isExpanded(row), treeNode.isLeaf(), row, true);
    }

    @Override
    public void toggleExpansion(ModelItem last) {
        if (last == SoapUI.getWorkspace()) {
            return;
        }

        super.toggleExpansion(last);
    }
}
