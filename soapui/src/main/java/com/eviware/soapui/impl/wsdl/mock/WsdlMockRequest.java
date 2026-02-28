

package com.eviware.soapui.impl.wsdl.mock;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.support.AbstractMockRequest;
import com.eviware.soapui.impl.wsdl.support.soap.SoapUtils;
import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.impl.wsdl.support.wss.IncomingWss;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.xml.XmlUtils;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.w3c.dom.Document;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Vector;

/**
 * Request-class created when receiving an external request to a WsdlMockService
 *
 * @author ole.matzura
 */

public class WsdlMockRequest extends AbstractMockRequest {
    private SoapVersion soapVersion;
    private String soapAction;
    private Vector<Object> wssResult;

    public WsdlMockRequest(HttpServletRequest request, HttpServletResponse response, WsdlMockRunContext context)
            throws Exception {

        super(request, response, context);

    }


    public SoapVersion getSoapVersion() {
        return soapVersion;
    }

    public String getProtocol() {
        return super.getProtocol();
    }

    public Vector<?> getWssResult() {
        return wssResult;
    }


    public void setRequestContent(String requestContent) {
        super.setRequestContent(requestContent);
        setRequestXmlObject(null);

        try {
            soapVersion = SoapUtils.deduceSoapVersion(getRequest().getContentType(), getRequestXmlObject());
        } catch (XmlException e) {
            SoapUI.logError(e);
        }

        if (soapVersion == null) {
            soapVersion = SoapVersion.Soap11;
        }
    }


    @Override
    public XmlObject getContentElement() throws XmlException {
        return SoapUtils.getContentElement(getRequestXmlObject(), soapVersion);
    }

    public String getSoapAction() {
        return soapAction;
    }

    public void setSoapAction(String soapAction) {
        this.soapAction = soapAction;
    }

    protected void initProtocolSpecificPostContent(WsdlMockRunContext context, String contentType) throws IOException {
        if (!isMultiPart(contentType)) {
            addWSSResult(context, getRequestContent());
        }
        initSoapVersion(contentType);

        soapAction = SoapUtils.getSoapAction(soapVersion, getRequestHeaders());
    }

    private void addWSSResult(WsdlMockRunContext context, String requestContent) throws IOException {
        WsdlMockService mockService = (WsdlMockService) context.getMockService();
        if (StringUtils.hasContent(mockService.getIncomingWss())) {
            IncomingWss incoming = mockService.getProject().getWssContainer()
                    .getIncomingWssByName(mockService.getIncomingWss());
            if (incoming != null) {
                Document dom = XmlUtils.parseXml(requestContent);
                try {
                    wssResult = incoming.processIncoming(dom, context);
                    if (wssResult != null && wssResult.size() > 0) {
                        StringWriter writer = new StringWriter();
                        XmlUtils.serialize(dom, writer);
                        setActualRequestContent(requestContent);
                        super.setRequestContent(writer.toString());
                        super.refreshRequestXmlObject();
                    }
                } catch (Exception e) {
                    if (wssResult == null) {
                        wssResult = new Vector<>();
                    }
                    wssResult.add(e);
                }
            }
        }
    }

    private void initSoapVersion(String contentType) {
        try {
            soapVersion = SoapUtils.deduceSoapVersion(contentType, getRequestXmlObject());
        } catch (Exception e) {
            // ignore non xml requests
        }

        if (soapVersion == null) {
            soapVersion = SoapVersion.Soap11;
        }
    }


}
