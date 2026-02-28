

package com.eviware.soapui.impl.wsdl.testcase;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.support.AbstractSubmitContext;
import com.eviware.soapui.model.testsuite.ProjectRunContext;
import com.eviware.soapui.model.testsuite.ProjectRunner;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.types.StringToObjectMap;

public class WsdlProjectRunContext extends AbstractSubmitContext<WsdlProject> implements ProjectRunContext {
    private final WsdlProjectRunner testScenarioRunner;

    public WsdlProjectRunContext(WsdlProjectRunner testScenarioRunner, StringToObjectMap properties) {
        super(testScenarioRunner.getTestRunnable(), properties);
        this.testScenarioRunner = testScenarioRunner;
    }

    public WsdlProject getProject() {
        return getModelItem();
    }

    public ProjectRunner getProjectRunner() {
        return testScenarioRunner;
    }

    public TestRunner getTestRunner() {
        return testScenarioRunner;
    }

    public Object getProperty(String name) {
        return get(name);
    }
}
