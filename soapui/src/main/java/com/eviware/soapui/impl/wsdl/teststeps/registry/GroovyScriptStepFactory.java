

package com.eviware.soapui.impl.wsdl.teststeps.registry;

import com.eviware.soapui.config.TestStepConfig;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlGroovyScriptTestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;

/**
 * Factory for creation GroovyScript steps
 *
 * @author Ole.Matzura
 */

public class GroovyScriptStepFactory extends WsdlTestStepFactory {
    public static final String GROOVY_TYPE = "groovy";

    public GroovyScriptStepFactory() {
        super(GROOVY_TYPE, "Groovy Script", "Executes the specified groovy script", "/groovy_script_step.png");
    }

    public WsdlTestStep buildTestStep(WsdlTestCase testCase, TestStepConfig config, boolean forLoadTest) {
        return new WsdlGroovyScriptTestStep(testCase, config, forLoadTest);
    }

    public TestStepConfig createNewTestStep(WsdlTestCase testCase, String name) {
        TestStepConfig testStepConfig = TestStepConfig.Factory.newInstance();
        testStepConfig.setType(GROOVY_TYPE);
        testStepConfig.setName(name);
        return testStepConfig;
    }

    public boolean canCreate() {
        return true;
    }
}
