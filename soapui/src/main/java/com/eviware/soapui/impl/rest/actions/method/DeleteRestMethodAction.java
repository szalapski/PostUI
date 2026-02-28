

package com.eviware.soapui.impl.rest.actions.method;

import com.eviware.soapui.impl.rest.RestMethod;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Deletes a RestMethod from its containing Resource
 *
 * @author Dain Nilsson
 */

public class DeleteRestMethodAction extends AbstractSoapUIAction<RestMethod> {
    public DeleteRestMethodAction() {
        super("Delete", "Deletes this Method");
    }

    public void perform(RestMethod method, Object param) {
        if (UISupport.confirm("Delete Method [" + method.getName() + "] from [" + method.getOperation().getName() + "]",
                "Delete Method")) {
            method.getOperation().deleteMethod(method);
        }
    }
}
