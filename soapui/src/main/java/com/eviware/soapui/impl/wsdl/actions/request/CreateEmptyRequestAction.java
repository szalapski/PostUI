

package com.eviware.soapui.impl.wsdl.actions.request;

import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.support.UISupport;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.ActionEvent;

/**
 * Creates an empty WsdlRequest containing a SOAP Envelope and empty Body
 *
 * @author Ole.Matzura
 */

public class CreateEmptyRequestAction extends AbstractAction {
    private final WsdlRequest request;

    public CreateEmptyRequestAction(WsdlRequest request) {
        super("Create empty");
        this.request = request;
        putValue(Action.SMALL_ICON, UISupport.createImageIcon("/create_empty_request.gif"));
        putValue(Action.SHORT_DESCRIPTION, "Creates an empty SOAP request");
    }

    public void actionPerformed(ActionEvent e) {
        if (UISupport.confirm("Overwrite existing request?", "Create Empty")) {
            WsdlInterface iface = (WsdlInterface) request.getOperation().getInterface();
            request.setRequestContent(iface.getMessageBuilder().buildEmptyMessage());
        }
    }
}
