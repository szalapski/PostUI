

package com.eviware.soapui.impl.support.components;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.submit.transports.http.DocumentContent;
import com.eviware.soapui.impl.wsdl.submit.transports.http.HttpResponse;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlContext;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.support.editor.xml.support.AbstractXmlDocument;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;

import javax.annotation.Nonnull;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * XmlDocument for the response to a WsdlRequest
 *
 * @author ole.matzura
 */

public class ResponseXmlDocument extends AbstractXmlDocument implements PropertyChangeListener {
    private final WsdlRequest request;
    private boolean settingResponse;

    public ResponseXmlDocument(WsdlRequest request) {
        this.request = request;
        request.addPropertyChangeListener(this);
    }

    @Nonnull
    @Override
    public DocumentContent getDocumentContent(Format format) {
        Response response = request.getResponse();
        return new DocumentContent(response == null ? null : response.getContentType(), response == null ? null : response.getContentAsString());
    }

    @Override
    public void setDocumentContent(DocumentContent documentContent) {
        HttpResponse response = request.getResponse();
        if (response != null) {
            try {
                settingResponse = true;
                response.setResponseContent(documentContent.getContentAsString());
                fireContentChanged();
            } finally {
                settingResponse = false;
            }
        }
    }

    @Override
    public String getContentType() {
        Response response = request.getResponse();
        return response == null ? null : response.getContentType();
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (settingResponse) {
            return;
        }

        if (evt.getPropertyName().equals(WsdlRequest.RESPONSE_PROPERTY)
                || evt.getPropertyName().equals(WsdlRequest.RESPONSE_CONTENT_PROPERTY)) {
            fireContentChanged();
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
        request.removePropertyChangeListener(this);
    }
}
