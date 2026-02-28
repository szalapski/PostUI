

package com.eviware.soapui.impl.wsdl.teststeps.registry;

import com.eviware.soapui.config.TestStepConfig;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.JdbcRequestTestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;

/**
 * Factory for creation Delay steps
 *
 * @author Ole.Matzura
 */

public class JdbcRequestTestStepFactory extends WsdlTestStepFactory {
    public static final String JDBC_TYPE = "jdbc";

    public JdbcRequestTestStepFactory() {
        super(JDBC_TYPE, "JDBC Request", "Jdbc Request returns xml result", "/jdbc_request_step.png");
    }

    public WsdlTestStep buildTestStep(WsdlTestCase testCase, TestStepConfig config, boolean forLoadTest) {
        return new JdbcRequestTestStep(testCase, config, forLoadTest);
    }

    public TestStepConfig createNewTestStep(WsdlTestCase testCase, String name) {
        TestStepConfig testStepConfig = TestStepConfig.Factory.newInstance();
        testStepConfig.setType(JDBC_TYPE);
        testStepConfig.setName(name);
        return testStepConfig;
    }

    public boolean canCreate() {
        return true;
    }
}
