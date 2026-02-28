

package com.eviware.soapui.impl.wsdl.panels.mockoperation;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.mock.WsdlMockResponse;
import com.eviware.soapui.impl.wsdl.submit.transports.http.DocumentContent;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlContext;
import com.eviware.soapui.model.mock.MockResponse;
import com.eviware.soapui.support.editor.xml.support.AbstractXmlDocument;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;

import javax.annotation.Nonnull;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * XmlDocument for a WsdlMockResponse
 *
 * @author ole.matzura
 */

public class MockResponseXmlDocument extends AbstractXmlDocument implements PropertyChangeListener {
    private final MockResponse mockResponse;

    public MockResponseXmlDocument(MockResponse response) {
        this.mockResponse = response;

        mockResponse.addPropertyChangeListener(WsdlMockResponse.RESPONSE_CONTENT_PROPERTY, this);
    }

    public SchemaTypeSystem getTypeSystem() {
        try {
            if (mockResponse instanceof WsdlMockResponse) {
                WsdlOperation operation = (WsdlOperation) mockResponse.getMockOperation().getOperation();
                if (operation != null) {
                    WsdlInterface iface = operation.getInterface();
                    WsdlContext wsdlContext = iface.getWsdlContext();
                    return wsdlContext.getSchemaTypeSystem();
                }
            }
        } catch (Exception e1) {
            SoapUI.logError(e1);
        }

        return XmlBeans.getBuiltinTypeSystem();
    }

    @Override
    public void setDocumentContent(DocumentContent documentContent) {
        mockResponse.setResponseContent(documentContent.getContentAsString());
    }

    @Override
    public String getContentType() {
        return mockResponse.getContentType();
    }

    public void propertyChange(PropertyChangeEvent arg0) {
        fireContentChanged();
    }

    @Override
    public void release() {
        mockResponse.removePropertyChangeListener(WsdlMockResponse.RESPONSE_CONTENT_PROPERTY, this);
        super.release();
    }

    @Nonnull
    @Override
    public DocumentContent getDocumentContent(Format format) {
        return new DocumentContent(mockResponse.getContentType(), mockResponse.getResponseContent());
    }
}
