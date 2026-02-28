

package com.eviware.soapui.impl.rest.actions.resource;

import com.eviware.soapui.impl.rest.RestResource;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Deletes a RestResource from its containing Service or Resource
 *
 * @author Ole.Matzura
 */

public class DeleteRestResourceAction extends AbstractSoapUIAction<RestResource> {
    public DeleteRestResourceAction() {
        super("Delete", "Deletes this Resource");
    }

    public void perform(RestResource resource, Object param) {
        if (UISupport.confirm("Delete Resource [" + resource.getName() + "] from ["
                + resource.getResourceContainer().getName() + "]. This will also delete all the child resources and test steps!", "Delete Resource")) {
            resource.getResourceContainer().deleteResource(resource);
        }
    }
}
