

package com.eviware.soapui.impl.wsdl.actions.testcase;

import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Moves the specified WsdlTestCase down one step in the WsdlTestSuites list of
 * WsdlTestCases
 *
 * @author ole.matzura
 */

public class MoveTestCaseDownAction extends AbstractSoapUIAction<WsdlTestCase> {
    public MoveTestCaseDownAction() {
        super("Move TestCase Down", "Moves this TestCase down");
    }

    public void perform(WsdlTestCase testCase, Object param) {
        WsdlTestSuite testSuite = testCase.getTestSuite();
        int ix = testSuite.getIndexOfTestCase(testCase);
        if (ix == -1 || ix >= testSuite.getTestCaseCount() - 1) {
            return;
        }

        testSuite.moveTestCase(ix, 1);
        UISupport.select(testCase);
    }
}
