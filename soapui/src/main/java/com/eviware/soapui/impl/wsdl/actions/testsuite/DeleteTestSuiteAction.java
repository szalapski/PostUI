

package com.eviware.soapui.impl.wsdl.actions.testsuite;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Removes a WsdlTestSuite from its WsdlProject
 *
 * @author Ole.Matzura
 */

public class DeleteTestSuiteAction extends AbstractSoapUIAction<WsdlTestSuite> {
    public DeleteTestSuiteAction() {
        super("Remove", "Removes this TestSuite from the project");
        // putValue( Action.ACCELERATOR_KEY, UISupport.getKeyStroke( "DELETE" ));
    }

    public void perform(WsdlTestSuite testSuite, Object param) {
        for (int c = 0; c < testSuite.getTestCaseCount(); c++) {
            if (SoapUI.getTestMonitor().hasRunningTest(testSuite.getTestCaseAt(c))) {
                UISupport.showErrorMessage("Cannot remove testSuite due to running tests");
                return;
            }
        }

        if (UISupport.confirm("Remove TestSuite [" + testSuite.getName() + "] from project", "Remove TestSuite")) {
            ((WsdlProject) testSuite.getProject()).removeTestSuite(testSuite);
        }
    }
}
