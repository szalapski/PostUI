

package com.eviware.soapui.support.swing;

import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lars
 */
public class TreePathUtils {
    public static TreePath getPath(TreeNode treeNode) {
        List<Object> nodes = new ArrayList<>();
        if (treeNode != null) {
            nodes.add(treeNode);
            treeNode = treeNode.getParent();
            while (treeNode != null) {
                nodes.add(0, treeNode);
                treeNode = treeNode.getParent();
            }
        }

        return nodes.isEmpty() ? null : new TreePath(nodes.toArray());
    }
}
