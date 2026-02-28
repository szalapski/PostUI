

package com.eviware.soapui.impl.wsdl.submit;

import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.model.iface.SoapUIListener;
import com.eviware.soapui.model.iface.SubmitContext;

/**
 * Filter for modifying a request before it is sent
 *
 * @author Ole.Matzura
 */

public interface RequestFilter extends SoapUIListener {
    public void filterRequest(SubmitContext context, Request request);

    public void afterRequest(SubmitContext context, Request request);

    /**
     * @deprecated
     */

    public void afterRequest(SubmitContext context, Response response);
}
