

package com.eviware.soapui.impl.wsdl.teststeps.registry;

import com.eviware.soapui.config.TestStepConfig;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlRunTestCaseTestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;

/**
 * Factory for creation GroovyScript steps
 *
 * @author Ole.Matzura
 */

public class RunTestCaseStepFactory extends WsdlTestStepFactory {
    public static final String RUNTESTCASE_TYPE = "calltestcase";

    public RunTestCaseStepFactory() {
        super(RUNTESTCASE_TYPE, "Run TestCase", "Runs another TestCase with the specified properties",
                "/run_test_case_step.png");
    }

    public WsdlTestStep buildTestStep(WsdlTestCase testCase, TestStepConfig config, boolean forLoadTest) {
        return new WsdlRunTestCaseTestStep(testCase, config, forLoadTest);
    }

    public TestStepConfig createNewTestStep(WsdlTestCase testCase, String name) {
        TestStepConfig testStepConfig = TestStepConfig.Factory.newInstance();
        testStepConfig.setType(RUNTESTCASE_TYPE);
        testStepConfig.setName(name);
        return testStepConfig;
    }

    public boolean canCreate() {
        return true;
    }
}
