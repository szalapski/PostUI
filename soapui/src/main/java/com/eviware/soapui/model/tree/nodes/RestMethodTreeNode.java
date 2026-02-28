

package com.eviware.soapui.model.tree.nodes;

import com.eviware.soapui.impl.rest.RestMethod;
import com.eviware.soapui.impl.rest.RestRequest;
import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.model.tree.AbstractModelItemTreeNode;
import com.eviware.soapui.model.tree.SoapUITreeModel;
import com.eviware.soapui.model.tree.SoapUITreeNode;
import com.eviware.soapui.support.UISupport;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * SoapUITreeNode for RestRequest implementations
 *
 * @author dain.nilsson
 */

public class RestMethodTreeNode extends AbstractModelItemTreeNode<RestMethod> {
    private List<RequestTreeNode> requestNodes = new ArrayList<>();
    private ReorderPropertyChangeListener propertyChangeListener = new ReorderPropertyChangeListener();

    public RestMethodTreeNode(RestMethod method, SoapUITreeModel treeModel) {
        super(method, method.getParent(), treeModel);
        treeModel.mapModelItem(this);

        for (RestRequest request : method.getRequestList()) {
            requestAdded(request);
        }
    }

    @Override
    public int getChildCount() {
        return requestNodes.size();
    }

    @Override
    public SoapUITreeNode getChildNode(int index) {
        return requestNodes.get(index);
    }

    @Override
    public int getIndexOfChild(Object child) {
        return requestNodes.indexOf(child);
    }

    public void requestAdded(Request request) {
        RequestTreeNode requestTreeNode = new RequestTreeNode(request, getTreeModel());
        requestNodes.add(requestTreeNode);
        reorder(false);
        request.addPropertyChangeListener(Request.NAME_PROPERTY, propertyChangeListener);
        getTreeModel().notifyNodeInserted(requestTreeNode);
    }

    public void requestRemoved(Request request) {
        SoapUITreeNode requestTreeNode = getTreeModel().getTreeNode(request);
        if (requestNodes.contains(requestTreeNode)) {
            getTreeModel().notifyNodeRemoved(requestTreeNode);
            requestNodes.remove(requestTreeNode);
            request.removePropertyChangeListener(propertyChangeListener);
        } else {
            throw new RuntimeException("Removing unknown request");
        }
    }

    public void release() {
        super.release();

        for (RequestTreeNode treeNode : requestNodes) {
            treeNode.getModelItem().removePropertyChangeListener(Request.NAME_PROPERTY, propertyChangeListener);
            treeNode.release();
        }
    }

    public void propertyChange(final PropertyChangeEvent evt) {
        UISupport.invokeAndWaitIfNotInEDT(new Runnable() {
            @Override
            public void run() {
                RestMethodTreeNode.super.propertyChange(evt);
                if (evt.getPropertyName().equals("childRequests")) {
                    if (evt.getNewValue() != null) {
                        requestAdded((RestRequest) evt.getNewValue());
                    } else {
                        requestRemoved((RestRequest) evt.getOldValue());
                    }
                }
            }
        });
    }
}
