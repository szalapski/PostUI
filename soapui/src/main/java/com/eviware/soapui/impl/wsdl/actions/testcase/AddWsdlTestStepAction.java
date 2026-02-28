

package com.eviware.soapui.impl.wsdl.actions.testcase;

import com.eviware.soapui.analytics.Analytics;
import com.eviware.soapui.config.TestStepConfig;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;
import com.eviware.soapui.impl.wsdl.teststeps.registry.WsdlTestStepFactory;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import static com.eviware.soapui.analytics.SoapUIActions.ADD_NEW_TEST_STEP;

/**
 * Adds a WsdlTestStep specified by the supplied WsdlTestStepFactory to a
 * WsdlTestCase
 *
 * @author ole.matzura
 */

public class AddWsdlTestStepAction extends AbstractSoapUIAction<WsdlTestCase> {
    public final static String SOAPUI_ACTION_ID = "AddWsdlTestStepAction";

    public AddWsdlTestStepAction() {
        super("Add Step", "Adds a TestStep to this TestCase");
    }

    public void perform(WsdlTestCase testCase, Object param) {
        WsdlTestStepFactory factory = (WsdlTestStepFactory) param;

        if (!factory.canAddTestStepToTestCase(testCase)) {
            return;
        }

        String name = UISupport.prompt("Specify name for new step", "Add Step", factory.getTestStepName());

        if (name == null) {
            return;
        }
        while (testCase.getTestStepByName(name.trim()) != null) {
            name = UISupport.prompt("Specify unique name of TestStep", "Rename TestStep", name);
            if (StringUtils.isNullOrEmpty(name)) {
                return;
            }
        }
        TestStepConfig newTestStepConfig = factory.createNewTestStep(testCase, name);
        if (newTestStepConfig != null) {
            WsdlTestStep testStep = testCase.addTestStep(newTestStepConfig);
            if (testStep != null) {
                UISupport.selectAndShow(testStep);
                Analytics.trackAction(ADD_NEW_TEST_STEP, "Type", testStep.getClass().getSimpleName());
            }
        }
    }
}
