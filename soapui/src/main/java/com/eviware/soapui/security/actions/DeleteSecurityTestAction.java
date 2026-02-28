

package com.eviware.soapui.security.actions;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.security.SecurityTest;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Removes a SecurityTest from its WsdlTestCase
 *
 * @author Ole.Matzura
 */

public class DeleteSecurityTestAction extends AbstractSoapUIAction<SecurityTest> {
    public DeleteSecurityTestAction() {
        super("Remove", "Removes this Test Schedule from the test-case");
    }

    public void perform(SecurityTest securityTest, Object param) {

        if (SoapUI.getTestMonitor().hasRunningSecurityTest((securityTest.getTestCase()))) {
            UISupport.showErrorMessage("Cannot remove test while tests are running");
            return;
        }

        if (UISupport.confirm("Remove SecurityTest [" + securityTest.getName() + "] from test-case",
                "Remove SecurityTest")) {
            ((WsdlTestCase) securityTest.getTestCase()).removeSecurityTest(securityTest);
        }
    }
}
