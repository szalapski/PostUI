

package com.eviware.soapui.impl.rest.support;

import com.eviware.soapui.impl.wsdl.submit.transports.http.HttpResponse;
import com.eviware.soapui.model.iface.TypedContent;

public interface MediaTypeHandler {
    public boolean canHandle(String contentType);

    public String createXmlRepresentation(HttpResponse response);

    public String createXmlRepresentation(TypedContent typedContent);
}
