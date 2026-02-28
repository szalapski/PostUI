

package com.eviware.soapui.impl.wsdl.submit;

import com.eviware.soapui.impl.rest.RestRequestInterface;
import com.eviware.soapui.impl.rest.RestResource;

public interface RestMessageExchange extends HttpMessageExchange {
    public RestResource getResource();

    public RestRequestInterface getRestRequest();
}
