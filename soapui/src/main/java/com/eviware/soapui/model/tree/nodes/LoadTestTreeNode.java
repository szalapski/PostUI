

package com.eviware.soapui.model.tree.nodes;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.testsuite.LoadTest;
import com.eviware.soapui.model.tree.AbstractModelItemTreeNode;
import com.eviware.soapui.model.tree.SoapUITreeModel;

/**
 * SoapUITreeNode for LoadTest implementations
 *
 * @author Ole.Matzura
 */

public class LoadTestTreeNode extends AbstractModelItemTreeNode<LoadTest> {
    public LoadTestTreeNode(LoadTest loadTest, ModelItem parent, SoapUITreeModel treeModel) {
        super(loadTest, parent, treeModel);
    }
}
