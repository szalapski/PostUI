

package com.eviware.soapui.impl.wsdl.submit.filters;

import com.eviware.soapui.impl.rest.RestRequestInterface;
import com.eviware.soapui.model.iface.SubmitContext;

/**
 * RequestFilter that affects REST requests
 *
 * @author Ole.Matzura
 */

public class RestRequestFilter extends HttpRequestFilter {
    @Override
    public void filterRestRequest(SubmitContext context, RestRequestInterface request) {
        filterHttpRequest(context, request);
    }
}
