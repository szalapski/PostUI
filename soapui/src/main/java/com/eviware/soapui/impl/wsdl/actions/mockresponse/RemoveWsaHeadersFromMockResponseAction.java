

package com.eviware.soapui.impl.wsdl.actions.mockresponse;

import com.eviware.soapui.impl.wsdl.mock.WsdlMockResponse;
import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.impl.wsdl.support.wsa.WsaUtils;
import com.eviware.soapui.model.propertyexpansion.DefaultPropertyExpansionContext;
import com.eviware.soapui.support.UISupport;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

/**
 * Removes WS-A headers from the specified WsdlRequests requestContent
 *
 * @author dragica.soldo
 */

public class RemoveWsaHeadersFromMockResponseAction extends AbstractAction {
    private final WsdlMockResponse mockResponse;

    public RemoveWsaHeadersFromMockResponseAction(WsdlMockResponse mockResponse) {
        super("Remove WS-A headers");
        this.mockResponse = mockResponse;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            SoapVersion soapVersion = mockResponse.getOperation().getInterface().getSoapVersion();
            String content = mockResponse.getResponseContent();
            WsaUtils wsaUtils = new WsaUtils(content, soapVersion, mockResponse.getOperation(),
                    new DefaultPropertyExpansionContext(mockResponse));
            content = wsaUtils.removeWSAddressing(mockResponse);
            mockResponse.setResponseContent(content);
        } catch (Exception e1) {
            UISupport.showErrorMessage(e1);
        } finally {
            UISupport.resetCursor();
        }
    }
}
