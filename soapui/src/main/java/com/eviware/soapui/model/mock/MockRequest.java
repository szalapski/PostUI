

package com.eviware.soapui.model.mock;

import com.eviware.soapui.impl.rest.RestRequestInterface;
import com.eviware.soapui.model.iface.Attachment;
import com.eviware.soapui.support.types.StringToStringsMap;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A Request to a MockService
 *
 * @author ole.matzura
 */

public interface MockRequest {
    Attachment[] getRequestAttachments();

    HttpServletRequest getHttpRequest();

    StringToStringsMap getRequestHeaders();

    String getRequestContent();

    MockRunContext getContext();

    MockRunContext getRequestContext();

    RestRequestInterface.HttpMethod getMethod();

    XmlObject getContentElement() throws XmlException;

    String getPath();

    byte[] getRawRequestData();

    String getProtocol();

    HttpServletResponse getHttpResponse();

    XmlObject getRequestXmlObject() throws XmlException;

    void setRequestContent(String xml);

    void refreshRequestXmlObject() throws XmlException;
}
