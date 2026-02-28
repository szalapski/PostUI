

package com.eviware.soapui.impl.wsdl.submit.transports.http;

import com.eviware.soapui.impl.support.AbstractHttpRequestInterface;
import com.eviware.soapui.model.iface.Response;

import java.net.URL;

public interface HttpResponse extends Response {
    public abstract AbstractHttpRequestInterface<?> getRequest();

    public abstract void setResponseContent(String responseContent);

    public abstract SSLInfo getSSLInfo();

    public abstract URL getURL();

    public String getMethod();

    public String getHttpVersion();

    public abstract int getStatusCode();
}
