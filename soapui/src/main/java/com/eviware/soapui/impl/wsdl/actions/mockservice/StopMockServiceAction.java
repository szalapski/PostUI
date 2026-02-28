

package com.eviware.soapui.impl.wsdl.actions.mockservice;

import com.eviware.soapui.analytics.Analytics;
import com.eviware.soapui.impl.rest.mock.RestMockService;
import com.eviware.soapui.impl.wsdl.mock.WsdlMockService;
import com.eviware.soapui.model.mock.MockRunner;
import com.eviware.soapui.model.mock.MockService;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import static com.eviware.soapui.analytics.SoapUIActions.STOP_REST_MOCK_FROM_NAVIGATOR;
import static com.eviware.soapui.analytics.SoapUIActions.STOP_SOAP_MOCK_FROM_NAVIGATOR;

/**
 * Clones a WsdlMockService
 *
 * @author Ole.Matzura
 */

public class StopMockServiceAction<MockServiceType extends MockService>
        extends AbstractSoapUIAction<MockServiceType> {
    public final static String SOAPUI_ACTION_ID = "StopMockServiceAction";

    public StopMockServiceAction() {
        super("Stop", "Stops the MockService if running");
    }

    public void perform(MockServiceType mockService, Object param) {
        try {
            MockRunner mockRunner = mockService.getMockRunner();
            if (mockRunner != null) {
                mockRunner.stop();
                sendAnalytic(mockService);
            }
        } catch (Exception e) {
            UISupport.showErrorMessage(e);
        }
    }

    private void sendAnalytic(MockServiceType mockService) {
        if (mockService != null) {
            if (mockService instanceof WsdlMockService) {
                Analytics.trackAction(STOP_SOAP_MOCK_FROM_NAVIGATOR);
            } else if (mockService instanceof RestMockService) {
                Analytics.trackAction(STOP_REST_MOCK_FROM_NAVIGATOR);
            }
        }
    }
}
