

package com.eviware.soapui.impl.wsdl.actions.teststep;

import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCaseRunner;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;
import com.eviware.soapui.model.testsuite.TestCaseRunContext;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;
import com.eviware.soapui.support.types.StringToObjectMap;

/**
 * Renames a WsdlTestStep
 *
 * @author Ole.Matzura
 */

public class RunFromTestStepAction extends AbstractSoapUIAction<WsdlTestStep> {
    public RunFromTestStepAction() {
        super("Run from here", "Runs the TestCase starting at this step");
    }

    public void perform(WsdlTestStep testStep, Object param) {
        StringToObjectMap properties = recoverContextProperties(testStep);
        properties.put(TestCaseRunContext.INTERACTIVE, Boolean.TRUE);

        WsdlTestCaseRunner testCaseRunner = new WsdlTestCaseRunner(testStep.getTestCase(), properties);
        testCaseRunner.setStartStep(testStep.getTestCase().getIndexOfTestStep(testStep));
        testCaseRunner.start(true);
    }

    private StringToObjectMap recoverContextProperties(WsdlTestStep testStep) {
        StringToObjectMap properties = null;
        try {
            if (testStep.getParent() instanceof WsdlTestCase) {
                properties = ((WsdlTestCase) testStep.getParent()).getRunFromHereContext();
            } else {
                properties = new StringToObjectMap();
            }
        } catch (Exception e) {
            properties = new StringToObjectMap();
        }
        return properties;
    }
}
