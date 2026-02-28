

package com.eviware.soapui.impl.rest.actions.resource;

import com.eviware.soapui.impl.rest.RestResource;
import com.eviware.soapui.impl.rest.actions.support.NewRestResourceActionBase;
import com.eviware.soapui.support.MessageSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Action for adding a new child REST resource.
 *
 * @author Ole.Matzura
 */

public class NewRestChildResourceAction extends NewRestResourceActionBase<RestResource> {
    public static final String SOAPUI_ACTION_ID = "NewRestChildResourceAction";
    public static final MessageSupport messages = MessageSupport.getMessages(NewRestChildResourceAction.class);

    public NewRestChildResourceAction() {
        super(messages.get("Title"), messages.get("Description"));
    }


    @Override
    protected List<RestResource> getResourcesFor(RestResource item) {
        List<RestResource> returnValue = new ArrayList<>();
        returnValue.add(item);
        returnValue.addAll(Arrays.asList(item.getAllChildResources()));
        return returnValue;
    }

    @Override
    protected RestResource addResourceTo(RestResource parentResource, String name, String path) {
        return parentResource.addNewChildResource(name, path);
    }


}
