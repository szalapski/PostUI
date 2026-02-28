

package com.eviware.soapui.impl.wsdl.submit;

import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;

import java.util.Vector;

public interface WsdlMessageExchange extends HttpMessageExchange {
    public abstract SoapVersion getSoapVersion();

    public abstract Vector<?> getRequestWssResult();

    public abstract Vector<?> getResponseWssResult();

    public WsdlOperation getOperation();
}
