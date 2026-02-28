

package com.eviware.soapui.impl.rest.actions.resource;

import com.eviware.soapui.impl.rest.RestResource;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Clones a WsdlRequest
 *
 * @author Ole.Matzura
 */

public class CloneRestResourceAction extends AbstractSoapUIAction<RestResource> {
    public static final String SOAPUI_ACTION_ID = "CloneRestResourceAction";

    public CloneRestResourceAction() {
        super("Clone Resource", "Creates a copy of this Resource");
    }

    public void perform(RestResource resource, Object param) {
        String name = UISupport.prompt("Specify name of cloned Resource", "Clone Resource",
                "Copy of " + resource.getName());
        if (name == null) {
            return;
        }

        RestResource newResource = resource.getResourceContainer().cloneResource(resource, name);
        UISupport.selectAndShow(newResource);
    }
}
