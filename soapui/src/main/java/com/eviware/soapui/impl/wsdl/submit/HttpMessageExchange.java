

package com.eviware.soapui.impl.wsdl.submit;

import com.eviware.soapui.model.iface.MessageExchange;

public interface HttpMessageExchange extends MessageExchange {
    public int getResponseStatusCode();

    public String getResponseContentType();
}
