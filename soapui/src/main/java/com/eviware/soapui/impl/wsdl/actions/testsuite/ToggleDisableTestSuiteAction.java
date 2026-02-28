

package com.eviware.soapui.impl.wsdl.actions.testsuite;

import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Toggles the disabled state of WsdlTestSuite
 *
 * @author Ole.Matzura
 */

public class ToggleDisableTestSuiteAction extends AbstractSoapUIAction<WsdlTestSuite> {
    public static final String SOAPUI_ACTION_ID = "ToggleDisableTestSuiteAction";

    public ToggleDisableTestSuiteAction() {
        super("Disable", "Disables this TestSuite");
    }

    public void perform(WsdlTestSuite testSuite, Object param) {
        testSuite.setDisabled(!testSuite.isDisabled());
    }
}
