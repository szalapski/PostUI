

package com.eviware.soapui.impl.wsdl.actions.loadtest;

import com.eviware.soapui.impl.wsdl.loadtest.WsdlLoadTest;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Clones a WsdlLoadTest
 *
 * @author Ole.Matzura
 */

public class CloneLoadTestAction extends AbstractSoapUIAction<WsdlLoadTest> {
    public CloneLoadTestAction() {
        super("Clone LoadTest", "Clones this LoadTest");
    }

    public void perform(WsdlLoadTest loadTest, Object param) {
        String name = UISupport.prompt("Specify name of cloned LoadTest", "Clone LoadTest",
                "Copy of " + loadTest.getName());
        if (name == null) {
            return;
        }

        WsdlLoadTest newLoadTest = loadTest.getTestCase().cloneLoadTest(loadTest, name);
        UISupport.selectAndShow(newLoadTest);
    }
}
