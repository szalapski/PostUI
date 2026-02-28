

package com.eviware.soapui.model.tree.nodes;

import com.eviware.soapui.model.mock.MockOperation;
import com.eviware.soapui.model.mock.MockResponse;
import com.eviware.soapui.model.tree.AbstractModelItemTreeNode;
import com.eviware.soapui.model.tree.SoapUITreeModel;
import com.eviware.soapui.model.tree.SoapUITreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * SoapUITreeNode for TestStep implementations
 *
 * @author Ole.Matzura
 */

public class MockOperationTreeNode extends AbstractModelItemTreeNode<MockOperation> {
    private List<MockResponseTreeNode> mockResponseNodes = new ArrayList<>();

    public MockOperationTreeNode(MockOperation mockOperation, SoapUITreeModel treeModel) {
        super(mockOperation, mockOperation.getMockService(), treeModel);

        for (int c = 0; c < mockOperation.getMockResponseCount(); c++) {
            MockResponse mockResponse = mockOperation.getMockResponseAt(c);
            mockResponseNodes.add(new MockResponseTreeNode(mockResponse, getTreeModel()));
        }

        treeModel.mapModelItems(mockResponseNodes);
    }

    @Override
    public void release() {
        super.release();

        for (MockResponseTreeNode treeNode : mockResponseNodes) {
            treeNode.release();
        }
    }

    public int getChildCount() {
        return mockResponseNodes.size();
    }

    public int getIndexOfChild(Object child) {
        return mockResponseNodes.indexOf(child);
    }

    public SoapUITreeNode getChildNode(int index) {
        return mockResponseNodes.get(index);
    }

    public void mockResponseAdded(MockResponse mockResponse) {
        MockResponseTreeNode treeNode = new MockResponseTreeNode(mockResponse, getTreeModel());
        mockResponseNodes.add(treeNode);
        getTreeModel().notifyNodeInserted(treeNode);
    }

    public void mockResponseRemoved(MockResponse mockResponse) {
        SoapUITreeNode treeNode = getTreeModel().getTreeNode(mockResponse);
        if (mockResponseNodes.contains(treeNode)) {
            getTreeModel().notifyNodeRemoved(treeNode);
            mockResponseNodes.remove(treeNode);
        } else {
            throw new RuntimeException("Removing unkown mockResponse; " + mockResponse.getName());
        }
    }
}
