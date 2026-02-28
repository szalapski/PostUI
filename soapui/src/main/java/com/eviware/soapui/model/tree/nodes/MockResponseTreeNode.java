

package com.eviware.soapui.model.tree.nodes;

import com.eviware.soapui.model.mock.MockResponse;
import com.eviware.soapui.model.tree.AbstractModelItemTreeNode;
import com.eviware.soapui.model.tree.SoapUITreeModel;

/**
 * SoapUITreeNode for Request implementations
 *
 * @author Ole.Matzura
 */

public class MockResponseTreeNode extends AbstractModelItemTreeNode<MockResponse> {
    public MockResponseTreeNode(MockResponse mockResponse, SoapUITreeModel treeModel) {
        super(mockResponse, mockResponse.getMockOperation(), treeModel);
    }
}
