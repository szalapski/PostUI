

package com.eviware.soapui.impl.wsdl.actions.teststep;

import com.eviware.soapui.analytics.Analytics;
import com.eviware.soapui.config.TestStepConfig;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;
import com.eviware.soapui.impl.wsdl.teststeps.registry.WsdlTestStepFactory;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import static com.eviware.soapui.analytics.SoapUIActions.ADD_NEW_TEST_STEP;

/**
 * Inserts a WsdlTestStep specified by the supplied WsdlTestStepFactory at the
 * position to the specified WsdlTestStep
 *
 * @author ole.matzura
 */

public class InsertWsdlTestStepAction extends AbstractSoapUIAction<WsdlTestStep> {
    public static final String SOAPUI_ACTION_ID = "InsertWsdlTestStepAction";

    public InsertWsdlTestStepAction() {
        super("Insert Step", "Inserts a TestStep at the position of this TestStep");
    }

    public void perform(WsdlTestStep testStep, Object param) {
        WsdlTestStepFactory factory = (WsdlTestStepFactory) param;
        WsdlTestCase testCase = testStep.getTestCase();

        if (!factory.canAddTestStepToTestCase(testCase)) {
            return;
        }

        String name = UISupport.prompt("Specify name for new step", "Insert Step", factory.getTestStepName());
        if (name != null) {
            TestStepConfig newTestStepConfig = factory.createNewTestStep(testCase, name);
            if (newTestStepConfig != null) {
                int ix = testCase.getIndexOfTestStep(testStep);
                testStep = testCase.insertTestStep(newTestStepConfig, ix + 1);
                if (testStep != null) {
                    UISupport.selectAndShow(testStep);
                    Analytics.trackAction(ADD_NEW_TEST_STEP, "Type", testStep.getClass().getSimpleName());
                }
            }
        }
    }
}
