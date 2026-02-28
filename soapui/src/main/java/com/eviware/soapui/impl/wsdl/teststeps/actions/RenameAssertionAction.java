

package com.eviware.soapui.impl.wsdl.teststeps.actions;

import com.eviware.soapui.impl.wsdl.teststeps.WsdlMessageAssertion;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Renames the specified assertion
 *
 * @author ole.matzura
 */

public class RenameAssertionAction extends AbstractSoapUIAction<WsdlMessageAssertion> {
    public RenameAssertionAction() {
        super("Rename", "Renames this assertion");
    }

    public void perform(WsdlMessageAssertion target, Object param) {
        String name = UISupport.prompt("Specify name for this assertion", "Rename Assertion", target.getName());
        if (name == null || name.equals(target.getName())) {
            return;
        }
        while (target.getAssertable().getAssertionByName(name.trim()) != null) {
            name = UISupport.prompt("Specify unique name of Assertion", "Rename Assertion", target.getName());
            if (name == null || name.equals(target.getName())) {
                return;
            }
        }

        target.setName(name);
    }
}
