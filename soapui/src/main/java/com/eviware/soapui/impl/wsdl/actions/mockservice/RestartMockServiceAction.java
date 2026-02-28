

package com.eviware.soapui.impl.wsdl.actions.mockservice;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.model.mock.MockService;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Clones a WsdlMockService
 *
 * @author Ole.Matzura
 */

public class RestartMockServiceAction<MockServiceType extends MockService>
        extends AbstractSoapUIAction<MockServiceType> {
    public final static String SOAPUI_ACTION_ID = "RestartMockServiceAction";

    public RestartMockServiceAction() {
        super("Restart", "(Re)starts this MockService and opens its desktop window if required");
    }

    public void perform(MockServiceType mockService, Object param) {
        try {
            UISupport.setHourglassCursor();
            if (!SoapUI.getDesktop().hasDesktopPanel(mockService)) {
                UISupport.showDesktopPanel(mockService);
            }

            if (mockService.getMockRunner() != null) {
                mockService.getMockRunner().stop();
            }

            mockService.start();
        } catch (Exception e) {
            UISupport.showErrorMessage(e);
        } finally {
            UISupport.resetCursor();
        }
    }
}
