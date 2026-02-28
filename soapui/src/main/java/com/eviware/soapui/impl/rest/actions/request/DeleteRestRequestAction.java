

package com.eviware.soapui.impl.rest.actions.request;

import com.eviware.soapui.impl.rest.RestMethod;
import com.eviware.soapui.impl.rest.RestRequest;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Deletes a WsdlRequest from its WsdlOperation
 *
 * @author Ole.Matzura
 */

public class DeleteRestRequestAction extends AbstractSoapUIAction<RestRequest> {
    public DeleteRestRequestAction() {
        super("Delete", "Deletes this Request");
    }

    public void perform(RestRequest request, Object param) {
        if (UISupport.confirm("Delete Request [" + request.getName() + "] from Resource ["
                + request.getOperation().getName() + "]", "Delete Request")) {
            RestMethod method = request.getRestMethod();
            method.removeRequest(request);
        }
    }
}
