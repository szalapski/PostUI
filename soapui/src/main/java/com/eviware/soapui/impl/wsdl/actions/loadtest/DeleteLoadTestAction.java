

package com.eviware.soapui.impl.wsdl.actions.loadtest;

import com.eviware.soapui.impl.wsdl.loadtest.WsdlLoadTest;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Removes a WsdlLoadTest from its WsdlTestCase
 *
 * @author Ole.Matzura
 */

public class DeleteLoadTestAction extends AbstractSoapUIAction<WsdlLoadTest> {
    public DeleteLoadTestAction() {
        super("Remove", "Removes this Test Schedule from the test-case");
    }

    public void perform(WsdlLoadTest loadTest, Object param) {
        if (loadTest.isRunning()) {
            UISupport.showErrorMessage("Can not remove running LoadTest");
            return;
        }

        if (UISupport.confirm("Remove LoadTest [" + loadTest.getName() + "] from test-casee", "Remove LoadTest")) {
            ((WsdlTestCase) loadTest.getTestCase()).removeLoadTest(loadTest);
        }
    }
}
