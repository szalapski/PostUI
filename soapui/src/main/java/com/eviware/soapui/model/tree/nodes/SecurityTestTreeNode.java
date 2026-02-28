

package com.eviware.soapui.model.tree.nodes;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.tree.AbstractModelItemTreeNode;
import com.eviware.soapui.model.tree.SoapUITreeModel;
import com.eviware.soapui.security.SecurityTest;

/**
 * SoapUITreeNode for LoadTest implementations
 *
 * @author Ole.Matzura
 */

public class SecurityTestTreeNode extends AbstractModelItemTreeNode<SecurityTest> {
    public SecurityTestTreeNode(SecurityTest securityTest, ModelItem parent, SoapUITreeModel treeModel) {
        super(securityTest, parent, treeModel);
    }
}
