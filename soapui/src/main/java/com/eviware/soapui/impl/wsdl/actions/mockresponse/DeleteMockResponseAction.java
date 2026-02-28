

package com.eviware.soapui.impl.wsdl.actions.mockresponse;

import com.eviware.soapui.model.mock.MockOperation;
import com.eviware.soapui.model.mock.MockResponse;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Deletes a MockResponse from its MockOperation
 *
 * @author ole.matzura
 */

public class DeleteMockResponseAction extends AbstractSoapUIAction<MockResponse> {
    public DeleteMockResponseAction() {
        super("Delete", "Deletes this MockResponse");
    }

    public void perform(MockResponse mockResponse, Object param) {
        if (UISupport.confirm("Delete MockResponse [" + mockResponse.getName() + "] from MockOperation ["
                + mockResponse.getMockOperation().getName() + "]", getName())) {
            MockOperation operation = mockResponse.getMockOperation();
            operation.removeMockResponse(mockResponse);
        }
    }
}
