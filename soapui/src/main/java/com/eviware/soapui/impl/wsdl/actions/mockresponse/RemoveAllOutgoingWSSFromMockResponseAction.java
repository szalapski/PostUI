

package com.eviware.soapui.impl.wsdl.actions.mockresponse;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.mock.WsdlMockResponse;
import com.eviware.soapui.impl.wsdl.support.wss.WssUtils;
import com.eviware.soapui.support.UISupport;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

/**
 * Removes all WSS outgoing Tokens from the specified MockResponse
 * requestContent
 *
 * @author dragica.soldo
 */

public class RemoveAllOutgoingWSSFromMockResponseAction extends AbstractAction {
    private final WsdlMockResponse response;

    public RemoveAllOutgoingWSSFromMockResponseAction(WsdlMockResponse response) {
        super("Remove all outgoing wss");
        this.response = response;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (UISupport.confirm("Remove all outgoing wss", "Remove all outgoing wss")) {
                String content = response.getResponseContent();
                response.setResponseContent(WssUtils.removeWSSOutgoing(content, response));
            }
        } catch (Exception e1) {
            SoapUI.logError(e1);
        }

    }
}
