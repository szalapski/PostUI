

package com.eviware.soapui.impl.wsdl.teststeps.actions;

import com.eviware.soapui.impl.wsdl.teststeps.WsdlMessageAssertion;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Toggles the disabled state of WsdlTestStep
 *
 * @author Ole.Matzura
 */

public class ToggleDisableAssertionAction extends AbstractSoapUIAction<WsdlMessageAssertion> {
    public static final String SOAPUI_ACTION_ID = "ToggleDisableAssertionAction";

    public ToggleDisableAssertionAction() {
        super("Disable", "Disables this TestCase");
    }

    public void perform(WsdlMessageAssertion testCase, Object param) {
        testCase.setDisabled(!testCase.isDisabled());
    }
}
