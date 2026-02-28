

package com.eviware.soapui.impl.wsdl.teststeps.actions;

import com.eviware.soapui.impl.wsdl.teststeps.WsdlMessageAssertion;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Deletes the specified WsdlMessageAssertion from its Assertable
 *
 * @author ole.matzura
 */

public class DeleteAssertionAction extends AbstractSoapUIAction<WsdlMessageAssertion> {
    public DeleteAssertionAction() {
        super("Remove", "Removes this assertion from its request");
    }

    public void perform(WsdlMessageAssertion target, Object param) {
        if (UISupport.confirm("Remove assertion [" + target.getName() + "] from ["
                + target.getAssertable().getModelItem().getName() + "]", "Remove Assertion")) {
            target.getAssertable().removeAssertion(target);
        }
    }
}
