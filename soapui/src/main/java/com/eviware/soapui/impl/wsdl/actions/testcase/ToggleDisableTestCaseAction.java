

package com.eviware.soapui.impl.wsdl.actions.testcase;

import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Toggles the disabled state of WsdlTestStep
 *
 * @author Ole.Matzura
 */

public class ToggleDisableTestCaseAction extends AbstractSoapUIAction<WsdlTestCase> {
    public static final String SOAPUI_ACTION_ID = "ToggleDisableTestCaseAction";

    public ToggleDisableTestCaseAction() {
        super("Disable", "Disables this TestCase");
    }

    public void perform(WsdlTestCase testCase, Object param) {
        testCase.setDisabled(!testCase.isDisabled());
    }
}
