

package com.eviware.soapui.impl.wsdl.actions.request;

import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Deletes a WsdlRequest from its WsdlOperation
 *
 * @author Ole.Matzura
 */

public class DeleteRequestAction extends AbstractSoapUIAction<WsdlRequest> {
    public DeleteRequestAction() {
        super("Delete", "Deletes this request");
    }

    public void perform(WsdlRequest request, Object param) {
        if (UISupport.confirm("Delete request [" + request.getName() + "] from operation ["
                + request.getOperation().getName() + "]", "Delete Request")) {
            WsdlOperation operation = (WsdlOperation) request.getOperation();
            operation.removeRequest(request);
        }
    }

}
