

package com.eviware.soapui.impl.wsdl.teststeps.registry;

import com.eviware.soapui.config.TestStepConfig;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;

/**
 * Abstract factory behaviour for WsdlTestStep factories
 *
 * @author Ole.Matzura
 */

public abstract class WsdlTestStepFactory {
    private final String typeName;
    private final String name;
    private final String description;
    private final String pathToIcon;

    public WsdlTestStepFactory(String typeName, String name, String description, String pathToIcon) {
        this.typeName = typeName;
        this.name = name;
        this.description = description;
        this.pathToIcon = pathToIcon;
    }

    public abstract WsdlTestStep buildTestStep(WsdlTestCase testCase, TestStepConfig config, boolean forLoadTest);

    public String getType() {
        return typeName;
    }

    public abstract TestStepConfig createNewTestStep(WsdlTestCase testCase, String name);

    public abstract boolean canCreate();

    public boolean promptForName() {
        return true;
    }

    public String getTestStepName() {
        return name;
    }

    public String getTestStepDescription() {
        return description;
    }

    public String getTestStepIconPath() {
        return pathToIcon;
    }

    public boolean canAddTestStepToTestCase(WsdlTestCase testCase) {
        return true;
    }
}
