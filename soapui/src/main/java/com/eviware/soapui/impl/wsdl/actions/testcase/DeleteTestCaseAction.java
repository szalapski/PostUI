

package com.eviware.soapui.impl.wsdl.actions.testcase;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Removes a WsdlTestCase from its WsdlTestSuite
 *
 * @author Ole.Matzura
 */

public class DeleteTestCaseAction extends AbstractSoapUIAction<WsdlTestCase> {
    public DeleteTestCaseAction() {
        super("Remove", "Removes this TestCase from the TestSuite");
    }

    public void perform(WsdlTestCase testCase, Object param) {
        if (SoapUI.getTestMonitor().hasRunningTest(testCase)) {
            UISupport.showErrorMessage("Cannot remove RestCase while tests are running");
            return;
        }

        if (UISupport.confirm("Remove TestCase [" + testCase.getName() + "] from TestSuite", "Remove TestCase")) {
            ((WsdlTestSuite) testCase.getTestSuite()).removeTestCase(testCase);
        }
    }

}
