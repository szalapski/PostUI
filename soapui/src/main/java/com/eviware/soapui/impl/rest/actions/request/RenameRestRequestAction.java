

package com.eviware.soapui.impl.rest.actions.request;

import com.eviware.soapui.impl.rest.RestRequest;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Renames a WsdlRequest
 *
 * @author Ole.Matzura
 */

public class RenameRestRequestAction extends AbstractSoapUIAction<RestRequest> {
    public RenameRestRequestAction() {
        super("Rename", "Renames this Request");
    }

    public void perform(RestRequest request, Object param) {
        String name = UISupport.prompt("Specify name of Request", "Rename Request", request.getName());
        if (name == null || name.equals(request.getName())) {
            return;
        }

        request.setName(name);
    }
}
