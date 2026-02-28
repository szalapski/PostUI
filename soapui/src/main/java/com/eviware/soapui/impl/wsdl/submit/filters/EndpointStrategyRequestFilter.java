

package com.eviware.soapui.impl.wsdl.submit.filters;

import com.eviware.soapui.model.iface.Operation;
import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.model.iface.SubmitContext;
import com.eviware.soapui.model.project.EndpointStrategy;

/**
 * RequestFilter for stripping whitespaces
 *
 * @author Ole.Matzura
 */

public class EndpointStrategyRequestFilter extends AbstractRequestFilter {
    public void filterRequest(SubmitContext context, Request wsdlRequest) {
        Operation operation = wsdlRequest.getOperation();
        if (operation != null) {
            EndpointStrategy endpointStrategy = operation.getInterface().getProject().getEndpointStrategy();
            if (endpointStrategy != null) {
                endpointStrategy.filterRequest(context, wsdlRequest);
            }
        }
    }
}
