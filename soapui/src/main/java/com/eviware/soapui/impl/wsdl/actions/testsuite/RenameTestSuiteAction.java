

package com.eviware.soapui.impl.wsdl.actions.testsuite;

import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Renames a WsdlTestSuite
 *
 * @author Ole.Matzura
 */

public class RenameTestSuiteAction extends AbstractSoapUIAction<WsdlTestSuite> {
    public RenameTestSuiteAction() {
        super("Rename", "Renames this TestSuite");
        // putValue( Action.ACCELERATOR_KEY, UISupport.getKeyStroke( "F2" ));
    }

    public void perform(WsdlTestSuite testSuite, Object param) {
        String name = UISupport.prompt("Specify name of TestSuite", "Rename TestSuite", testSuite.getName());
        if (name == null || name.equals(testSuite.getName())) {
            return;
        }
        while (testSuite.getProject().getTestSuiteByName(name.trim()) != null) {
            name = UISupport.prompt("Specify unique name of TestSuite", "Rename TestSuite", testSuite.getName());
            if (name == null || name.equals(testSuite.getName())) {
                return;
            }
        }

        testSuite.setName(name);
    }
}
