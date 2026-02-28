

package com.eviware.soapui.impl.wsdl.submit;

public interface RequestTransportFactory {
    public RequestTransport newRequestTransport();

    public String getProtocol();
}
