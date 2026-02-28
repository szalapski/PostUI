

package com.eviware.soapui.impl.wsdl.submit.transports.http;

import com.eviware.soapui.impl.wsdl.WsdlRequest;

import java.util.Vector;

/**
 * WSDL-specific extension to response
 *
 * @author ole.matzura
 */

public interface WsdlResponse extends HttpResponse {
    public Vector<?> getWssResult();

    public WsdlRequest getRequest();
}
