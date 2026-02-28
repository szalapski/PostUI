

package com.eviware.soapui.impl.wsdl.teststeps.actions;

import com.eviware.soapui.impl.wsdl.teststeps.WsdlMessageAssertion;
import com.eviware.soapui.model.testsuite.TestAssertion;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Clones the specified WsdlMessageAssertion
 *
 * @author ole.matzura
 */

public class CloneAssertionAction extends AbstractSoapUIAction<WsdlMessageAssertion> {
    public static final String SOAPUI_ACTION_ID = "CloneAssertionAction";

    public CloneAssertionAction() {
        super("Clone", "Clones this assertion");
    }

    public void perform(WsdlMessageAssertion target, Object param) {
        String name = target.getName();

        while (target.getName().equals(name)) {
            name = UISupport.prompt("Specify unique name for cloned assertion", "Clone Assertion", target.getName());
            if (name == null) {
                return;
            }
        }

        TestAssertion assertion = target.getAssertable().cloneAssertion(target, name);

        if (assertion.isConfigurable()) {
            assertion.configure();
        }
    }
}
