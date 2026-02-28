

package com.eviware.soapui.impl.wsdl.actions.testsuite;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Moves the specified WsdlTestCase down one step in the WsdlTestSuites list of
 * WsdlTestCases
 *
 * @author ole.matzura
 */

public class MoveTestSuiteDownAction extends AbstractSoapUIAction<WsdlTestSuite> {
    public MoveTestSuiteDownAction() {
        super("Move TestSuite Down", "Moves this TestSuite down");
    }

    public void perform(WsdlTestSuite testSuite, Object param) {
        WsdlProject project = testSuite.getProject();
        int ix = project.getIndexOfTestSuite(testSuite);
        if (ix == -1 || ix >= project.getTestSuiteCount() - 1) {
            return;
        }

        project.moveTestSuite(ix, 1);
        UISupport.select(testSuite);
    }
}
