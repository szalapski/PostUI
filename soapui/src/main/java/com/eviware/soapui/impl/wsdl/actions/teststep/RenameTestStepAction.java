

package com.eviware.soapui.impl.wsdl.actions.teststep;

import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Renames a WsdlTestStep
 *
 * @author Ole.Matzura
 */

public class RenameTestStepAction extends AbstractSoapUIAction<WsdlTestStep> {
    public RenameTestStepAction() {
        super("Rename", "Renames this TestStep");
    }

    public void perform(WsdlTestStep testStep, Object param) {
        String name = UISupport.prompt("Specify unique name of TestStep", "Rename TestStep", testStep.getName());
        if (name == null || name.equals(testStep.getName())) {
            return;
        }

        while (testStep.getTestCase().getTestStepByName(name.trim()) != null) {
            name = UISupport.prompt("Specify unique name of TestStep", "Rename TestStep", testStep.getName());
            if (name == null || name.equals(testStep.getName())) {
                return;
            }
        }

        testStep.setName(name);
    }
}
