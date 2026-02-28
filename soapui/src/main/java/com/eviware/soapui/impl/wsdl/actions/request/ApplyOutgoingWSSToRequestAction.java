

package com.eviware.soapui.impl.wsdl.actions.request;

import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.support.wss.OutgoingWss;
import com.eviware.soapui.model.propertyexpansion.DefaultPropertyExpansionContext;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.xml.XmlUtils;
import org.w3c.dom.Document;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.StringWriter;

/**
 * Prompts to add a WSS Username Token to the specified WsdlRequests
 * requestContent
 *
 * @author Ole.Matzura
 */

public class ApplyOutgoingWSSToRequestAction extends AbstractAction {
    private final WsdlRequest request;
    private final OutgoingWss outgoing;

    public ApplyOutgoingWSSToRequestAction(WsdlRequest request, OutgoingWss outgoing) {
        super("Apply \" " + outgoing.getName() + " \"");
        this.request = request;
        this.outgoing = outgoing;
    }

    public void actionPerformed(ActionEvent e) {
        String req = request.getRequestContent();

        try {
            UISupport.setHourglassCursor();
            Document dom = XmlUtils.parseXml(req);
            outgoing.processOutgoing(dom, new DefaultPropertyExpansionContext(request));
            StringWriter writer = new StringWriter();
            XmlUtils.serialize(dom, writer);
            request.setRequestContent(writer.toString());
        } catch (Exception e1) {
            UISupport.showErrorMessage(e1);
        } finally {
            UISupport.resetCursor();
        }
    }
}
