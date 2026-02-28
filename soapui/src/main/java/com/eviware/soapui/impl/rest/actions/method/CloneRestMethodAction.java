

package com.eviware.soapui.impl.rest.actions.method;

import com.eviware.soapui.impl.rest.RestMethod;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Clones a RestMethod
 *
 * @author Dain Nilsson
 */

public class CloneRestMethodAction extends AbstractSoapUIAction<RestMethod> {
    public static final String SOAPUI_ACTION_ID = "CloneRestMethodAction";

    public CloneRestMethodAction() {
        super("Clone Method", "Creates a copy of this Method");
    }

    public void perform(RestMethod method, Object param) {
        String name = UISupport.prompt("Specify name of cloned Method", "Clone Method", "Copy of " + method.getName());
        if (name == null) {
            return;
        }

        RestMethod newMethod = method.getOperation().cloneMethod(method, name);
        UISupport.selectAndShow(newMethod);
    }
}
