

package com.eviware.soapui.impl.wsdl.actions.request;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.support.wss.WssUtils;
import com.eviware.soapui.support.UISupport;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

/**
 * Removes all WSS outgoing Tokens from the specified WsdlRequests
 * requestContent
 *
 * @author dragica.soldo
 */

public class RemoveAllOutgoingWSSFromRequestAction extends AbstractAction {
    private final WsdlRequest request;

    public RemoveAllOutgoingWSSFromRequestAction(WsdlRequest request) {
        super("Remove all outgoing wss");
        this.request = request;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (UISupport.confirm("Remove all outgoing wss", "Remove all outgoing wss")) {
                String content = request.getRequestContent();
                request.setRequestContent(WssUtils.removeWSSOutgoing(content, request));
            }
        } catch (Exception e1) {
            SoapUI.logError(e1);
        }

    }
}
