

package com.eviware.soapui.impl.wsdl.teststeps.registry;

import com.eviware.soapui.config.ManualTestStepConfig;
import com.eviware.soapui.config.TestStepConfig;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.ManualTestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;

public class ManualTestStepFactory extends WsdlTestStepFactory {
    public static final String MANUAL_TEST_STEP = "manualTestStep";

    public ManualTestStepFactory() {
        super(MANUAL_TEST_STEP, "Manual TestStep", "Submits a Manual TestStep", "/manual_step.png");
    }

    public WsdlTestStep buildTestStep(WsdlTestCase testCase, TestStepConfig config, boolean forLoadTest) {
        return new ManualTestStep(testCase, config, forLoadTest);
    }

    public TestStepConfig createNewTestStep(WsdlTestCase testCase, String name) {
        TestStepConfig testStepConfig = TestStepConfig.Factory.newInstance();
        testStepConfig.setType(MANUAL_TEST_STEP);
        testStepConfig.setName(name);
        return testStepConfig;
    }

    public boolean canCreate() {
        return true;
    }

    public TestStepConfig createConfig(String stepName) {
        ManualTestStepConfig testRequestConfig = ManualTestStepConfig.Factory.newInstance();

        TestStepConfig testStep = TestStepConfig.Factory.newInstance();
        testStep.setType(MANUAL_TEST_STEP);
        testStep.setConfig(testRequestConfig);
        testStep.setName(stepName);
        return testStep;
    }
}
