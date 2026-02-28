

package com.eviware.soapui.impl.rest.actions.service;

import com.eviware.soapui.impl.rest.RestResource;
import com.eviware.soapui.impl.rest.RestService;
import com.eviware.soapui.impl.rest.actions.support.NewRestResourceActionBase;
import com.eviware.soapui.support.MessageSupport;

import java.util.List;

/**
 * Action for creating a new top-level REST resource.
 *
 * @author Ole.Matzura
 */

public class NewRestResourceAction extends NewRestResourceActionBase<RestService> {
    public static final String SOAPUI_ACTION_ID = "NewRestResourceAction";
    public static final MessageSupport messages = MessageSupport.getMessages(NewRestResourceAction.class);

    public NewRestResourceAction() {
        super(messages.get("Title"), messages.get("Description"));
    }


    @Override
    protected List<RestResource> getResourcesFor(RestService item) {
        return item.getResourceList();
    }

    @Override
    protected RestResource addResourceTo(RestService service, String name, String path) {
        return service.addNewResource(name, path);
    }

}
