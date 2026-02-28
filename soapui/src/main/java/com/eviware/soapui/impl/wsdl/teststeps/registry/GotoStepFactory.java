

package com.eviware.soapui.impl.wsdl.teststeps.registry;

import com.eviware.soapui.config.GotoStepConfig;
import com.eviware.soapui.config.TestStepConfig;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlGotoTestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;

/**
 * Factory for creation TransferValue steps
 *
 * @author Ole.Matzura
 */

public class GotoStepFactory extends WsdlTestStepFactory {
    public static final String GOTO_TYPE = "goto";

    public GotoStepFactory() {
        super(GOTO_TYPE, "Conditional Goto", "Transfers the execution to another TestStep based on xpath expressions",
                "/conditional_goto_step.png");
    }

    public WsdlTestStep buildTestStep(WsdlTestCase testCase, TestStepConfig config, boolean forLoadTest) {
        return new WsdlGotoTestStep(testCase, config, forLoadTest);
    }

    public TestStepConfig createNewTestStep(WsdlTestCase testCase, String name) {
        TestStepConfig testStepConfig = TestStepConfig.Factory.newInstance();
        testStepConfig.setType(GOTO_TYPE);
        testStepConfig.setName(name);
        testStepConfig.setConfig(GotoStepConfig.Factory.newInstance());
        return testStepConfig;
    }

    public boolean canCreate() {
        return true;
    }
}
