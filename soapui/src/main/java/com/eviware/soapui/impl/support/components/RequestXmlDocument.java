

package com.eviware.soapui.impl.support.components;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.submit.transports.http.DocumentContent;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlContext;
import com.eviware.soapui.support.editor.xml.support.AbstractXmlDocument;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;

import javax.annotation.Nonnull;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * XmlDocument for a WsdlRequest
 *
 * @author ole.matzura
 */

public class RequestXmlDocument extends AbstractXmlDocument implements PropertyChangeListener {
    private final WsdlRequest request;
    private boolean updating;

    public RequestXmlDocument(WsdlRequest request) {
        this.request = request;
        request.addPropertyChangeListener(WsdlRequest.REQUEST_PROPERTY, this);
    }

    @Override
    public void setDocumentContent(DocumentContent documentContent) {
        if (!updating) {
            updating = true;
            request.setRequestContent(documentContent.getContentAsString());
            fireContentChanged();
            updating = false;
        }
    }

    @Override
    public String getContentType() {
        return "application/soap+xml";
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (!updating) {
            updating = true;
            fireContentChanged();
            updating = false;
        }
    }

    public SchemaTypeSystem getTypeSystem() {
        WsdlInterface iface = request.getOperation().getInterface();
        WsdlContext wsdlContext = iface.getWsdlContext();
        try {
            return wsdlContext.getSchemaTypeSystem();
        } catch (Exception e1) {
            SoapUI.logError(e1);
            return XmlBeans.getBuiltinTypeSystem();
        }
    }

    public void release() {
        request.removePropertyChangeListener(WsdlRequest.REQUEST_PROPERTY, this);
    }

    @Nonnull
    @Override
    public DocumentContent getDocumentContent(Format format) {
        return new DocumentContent(null, request.getRequestContent());
    }
}
