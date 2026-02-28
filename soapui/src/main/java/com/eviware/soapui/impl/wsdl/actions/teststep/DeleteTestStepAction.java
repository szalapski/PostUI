

package com.eviware.soapui.impl.wsdl.actions.teststep;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Deletes a WsdlTestStep from its WsdlTestCase
 *
 * @author Ole.Matzura
 */

public class DeleteTestStepAction extends AbstractSoapUIAction<WsdlTestStep> {
    public DeleteTestStepAction() {
        super("Delete", "Deletes this TestStep");
    }

    public void perform(WsdlTestStep testStep, Object param) {
        if (SoapUI.getTestMonitor().hasRunningTest(testStep.getTestCase())) {
            UISupport.showErrorMessage("Cannot remove step while tests are running");
            return;
        }

        if (UISupport.confirm("Delete TestStep [" + testStep.getName() + "] from Testcase ["
                + testStep.getTestCase().getName() + "]", "Delete TestStep")) {
            ((WsdlTestCase) testStep.getTestCase()).removeTestStep(testStep);
        }
    }

}
