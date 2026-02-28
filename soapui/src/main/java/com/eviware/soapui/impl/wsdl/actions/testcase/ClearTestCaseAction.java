

package com.eviware.soapui.impl.wsdl.actions.testcase;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Clears a WsdlTestCase
 *
 * @author Ole.Matzura
 */

public class ClearTestCaseAction extends AbstractSoapUIAction<WsdlTestCase> {
    public ClearTestCaseAction() {
        super("Clear", "Clears this TestCase");
    }

    public void perform(WsdlTestCase testCase, Object param) {
        if (SoapUI.getTestMonitor().hasRunningTest(testCase)) {
            UISupport.showErrorMessage("Cannot clear TestCase while tests are running");
        } else if (UISupport.confirm("Remove all TestSteps and LoadTests from this TestCase?", "Clear TestCase")) {
            while (testCase.getLoadTestCount() > 0) {
                testCase.removeLoadTest(testCase.getLoadTestAt(0));
            }

            while (testCase.getTestStepCount() > 0) {
                testCase.removeTestStep(testCase.getTestStepAt(0));
            }
        }
    }
}
