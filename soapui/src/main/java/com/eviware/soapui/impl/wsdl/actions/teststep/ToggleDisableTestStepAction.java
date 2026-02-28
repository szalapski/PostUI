

package com.eviware.soapui.impl.wsdl.actions.teststep;

import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Toggles the disabled state of WsdlTestStep
 *
 * @author Ole.Matzura
 */

public class ToggleDisableTestStepAction extends AbstractSoapUIAction<WsdlTestStep> {
    public static final String SOAPUI_ACTION_ID = "ToggleDisableTestStepAction";

    public ToggleDisableTestStepAction() {
        super("Disable", "Disables this TestStep");
    }

    public void perform(WsdlTestStep testStep, Object param) {
        testStep.setDisabled(!testStep.isDisabled());
    }
}
