

package com.eviware.soapui.impl.rest.actions.method;

import com.eviware.soapui.impl.rest.RestMethod;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Renames a RestMethod
 *
 * @author Dain Nilsson
 */

public class RenameRestMethodAction extends AbstractSoapUIAction<RestMethod> {
    public RenameRestMethodAction() {
        super("Rename", "Renames this Resource");
    }

    public void perform(RestMethod method, Object param) {
        String name = UISupport.prompt("Specify new name for Method", "Rename Method", method.getName());
        if (name == null || name.equals(method.getName())) {
            return;
        }

        method.setName(name);
    }
}
