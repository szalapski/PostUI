

package com.eviware.soapui.impl.rest.actions.request;

import com.eviware.soapui.impl.rest.RestRequest;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Clones a WsdlRequest
 *
 * @author Ole.Matzura
 */

public class CloneRestRequestAction extends AbstractSoapUIAction<RestRequest> {
    public static final String SOAPUI_ACTION_ID = "CloneRestRequestAction";

    public CloneRestRequestAction() {
        super("Clone Request", "Creates a copy of this Request");
    }

    public void perform(RestRequest request, Object param) {
        String name = UISupport
                .prompt("Specify name of cloned Request", "Clone Request", "Copy of " + request.getName());
        if (name == null) {
            return;
        }

        RestRequest newRequest = request.getRestMethod().cloneRequest(request, name);

        UISupport.selectAndShow(newRequest);
    }
}
