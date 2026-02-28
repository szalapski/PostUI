

package com.eviware.soapui.impl.wsdl.actions.request;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.impl.wsdl.support.wsa.WsaUtils;
import com.eviware.soapui.model.propertyexpansion.DefaultPropertyExpansionContext;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

/**
 * Adds WS-A headers to the specified WsdlRequests requestContent
 *
 * @author dragica.soldo
 */

public class AddWsaHeadersToRequestAction extends AbstractAction {
    private final WsdlRequest request;

    public AddWsaHeadersToRequestAction(WsdlRequest request) {
        super("Add WS-A headers");
        this.request = request;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            SoapVersion soapVersion = request.getOperation().getInterface().getSoapVersion();
            String content = request.getRequestContent();
            WsaUtils wsaUtils = new WsaUtils(content, soapVersion, request.getOperation(),
                    new DefaultPropertyExpansionContext(request));
            content = wsaUtils.addWSAddressingRequest(request);
            request.setRequestContent(content);
        } catch (Exception e1) {
            SoapUI.logError(e1);
        }
    }
}
