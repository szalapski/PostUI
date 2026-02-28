

package com.eviware.soapui.impl.wsdl.actions.request;

import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Renames a WsdlRequest
 *
 * @author Ole.Matzura
 */

public class RenameRequestAction extends AbstractSoapUIAction<WsdlRequest> {
    public RenameRequestAction() {
        super("Rename", "Renames this request");
        // putValue( Action.ACCELERATOR_KEY, UISupport.getKeyStroke( "F2" ));
    }

    public void perform(WsdlRequest request, Object param) {
        String name = UISupport.prompt("Specify name of request", "Rename Request", request.getName());
        if (name == null || name.equals(request.getName())) {
            return;
        }

        request.setName(name);
    }

}
