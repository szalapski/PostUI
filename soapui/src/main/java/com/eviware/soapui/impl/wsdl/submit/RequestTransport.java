

package com.eviware.soapui.impl.wsdl.submit;

import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.model.iface.SubmitContext;

/**
 * Defines protocol-specific behaviour
 *
 * @author Ole.Matzura
 */

public interface RequestTransport {
    public final static String WSDL_REQUEST = "wsdlRequest";
    public static final String REQUEST_TRANSPORT = "requestTransport";

    public void addRequestFilter(RequestFilter filter);

    public void removeRequestFilter(RequestFilter filter);

    public void abortRequest(SubmitContext submitContext);

    public Response sendRequest(SubmitContext submitContext, Request request) throws Exception;

    public void insertRequestFilter(RequestFilter filter, RequestFilter refFilter );
}
