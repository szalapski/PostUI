

package com.eviware.soapui.impl.wsdl.teststeps.registry;

import com.eviware.soapui.config.PropertyTransfersStepConfig;
import com.eviware.soapui.config.TestStepConfig;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.PropertyTransfersTestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;

/**
 * Factory for creation TransferValue steps
 *
 * @author Ole.Matzura
 */

public class PropertyTransfersStepFactory extends WsdlTestStepFactory {
    public static final String TRANSFER_TYPE = "transfer";

    public PropertyTransfersStepFactory() {
        super(TRANSFER_TYPE, "Property Transfer", "Transfers values from the previous response to the next request",
                "/property_transfer_step.png");
    }

    public WsdlTestStep buildTestStep(WsdlTestCase testCase, TestStepConfig config, boolean forLoadTest) {
        return new PropertyTransfersTestStep(testCase, config, forLoadTest);
    }

    public TestStepConfig createNewTestStep(WsdlTestCase testCase, String name) {
        TestStepConfig testStepConfig = TestStepConfig.Factory.newInstance();
        testStepConfig.setType(TRANSFER_TYPE);
        testStepConfig.setName(name);
        testStepConfig.setConfig(PropertyTransfersStepConfig.Factory.newInstance());
        return testStepConfig;
    }

    public boolean canCreate() {
        return true;
    }

}
