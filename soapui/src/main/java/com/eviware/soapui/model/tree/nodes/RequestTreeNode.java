

package com.eviware.soapui.model.tree.nodes;

import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.model.tree.AbstractModelItemTreeNode;
import com.eviware.soapui.model.tree.SoapUITreeModel;

/**
 * SoapUITreeNode for Request implementations
 *
 * @author Ole.Matzura
 */

public class RequestTreeNode extends AbstractModelItemTreeNode<Request> {
    public RequestTreeNode(Request request, SoapUITreeModel treeModel) {
        super(request, request.getParent(), treeModel);
    }
}
