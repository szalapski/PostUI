

package com.eviware.soapui.impl.rest.actions.resource;

import com.eviware.soapui.impl.rest.RestResource;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Renames a WsdlRequest
 *
 * @author Ole.Matzura
 */

public class RenameRestResourceAction extends AbstractSoapUIAction<RestResource> {
    public RenameRestResourceAction() {
        super("Rename", "Renames this Resource");
    }

    public void perform(RestResource request, Object param) {
        String name = UISupport.prompt("Specify new name for Resource", "Rename Resource", request.getName());
        if (name == null || name.equals(request.getName())) {
            return;
        }

        request.setName(name);
    }
}
