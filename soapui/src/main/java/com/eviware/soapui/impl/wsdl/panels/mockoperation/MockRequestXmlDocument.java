

package com.eviware.soapui.impl.wsdl.panels.mockoperation;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.mock.WsdlMockResponse;
import com.eviware.soapui.impl.wsdl.submit.transports.http.DocumentContent;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlContext;
import com.eviware.soapui.model.mock.MockResponse;
import com.eviware.soapui.model.mock.MockResult;
import com.eviware.soapui.support.editor.xml.support.AbstractXmlDocument;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;

import javax.annotation.Nonnull;

/**
 * XmlDocument for the last request to a WsdlMockResponse
 *
 * @author ole.matzura
 */

public class MockRequestXmlDocument extends AbstractXmlDocument {
    private final MockResponse mockResponse;

    public MockRequestXmlDocument(MockResponse response) {
        this.mockResponse = response;
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
        MockResult mockResult = mockResponse.getMockResult();
        if (mockResult != null) {
            mockResult.getMockRequest().setRequestContent(documentContent.getContentAsString());
            fireContentChanged();
        } else {
            fireContentChanged();
        }
    }

    @Override
    public String getContentType() {
        MockResult mockResult = mockResponse.getMockResult();
        return String.valueOf(mockResult == null ? null : mockResult.getMockRequest().getRequestHeaders().get("Content-Type"));
    }

    @Nonnull
    @Override
    public DocumentContent getDocumentContent(Format format) {
        MockResult mockResult = mockResponse.getMockResult();
        final String requestContent = mockResult == null ? null : mockResult.getMockRequest().getRequestContent();
        return new DocumentContent(null, requestContent);
    }

}
