

package com.eviware.soapui.impl.wsdl.actions.mockservice;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.model.mock.MockService;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Removes a MockService from its WsdlProject
 *
 * @author Ole.Matzura
 */

public class DeleteMockServiceAction extends AbstractSoapUIAction<MockService> {
    public DeleteMockServiceAction() {
        super("Remove", "Removes this MockService from the Project");
    }

    public void perform(MockService mockService, Object param) {
        if (SoapUI.getMockEngine().hasRunningMock(mockService)) {
            UISupport.showErrorMessage("Cannot remove MockService while mocks are running");
            return;
        }

        if (UISupport.confirm("Remove MockService [" + mockService.getName() + "] from Project", "Remove MockService")) {
            mockService.getProject().removeMockService(mockService);
        }
    }

}
