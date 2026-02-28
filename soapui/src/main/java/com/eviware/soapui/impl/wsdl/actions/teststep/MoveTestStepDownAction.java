

package com.eviware.soapui.impl.wsdl.actions.teststep;

import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Moves the specified WsdlTestStep down one step in the WsdlTestCases list of
 * WsdlTestSteps
 *
 * @author ole.matzura
 */

public class MoveTestStepDownAction extends AbstractSoapUIAction<WsdlTestStep> {
    public MoveTestStepDownAction() {
        super("Move Step Down", "Moves this TestStep down");
    }

    public void perform(WsdlTestStep testStep, Object param) {
        WsdlTestCase testCase = testStep.getTestCase();
        int ix = testCase.getIndexOfTestStep(testStep);
        if (ix == -1 || ix >= testCase.getTestStepCount() - 1) {
            return;
        }

        testCase.moveTestStep(ix, 1);
        UISupport.select(testStep);
    }
}
