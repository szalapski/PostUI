

package com.eviware.soapui.impl.wsdl.submit;

public interface RequestFilterFactory {
    public String getProtocol();

    public RequestFilter createRequestFilter();
}
