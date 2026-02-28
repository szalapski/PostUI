

package com.eviware.soapui.impl.wsdl.panels.support;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.testsuite.ProjectRunner;
import com.eviware.soapui.model.testsuite.TestSuiteRunner;

import java.util.ArrayList;
import java.util.List;

public class MockProjectRunner extends AbstractMockTestRunner<WsdlProject> implements ProjectRunner {
    public MockProjectRunner(WsdlProject project) {
        super(project, null);
        setRunContext(new MockProjectRunContext(this));
    }

    public WsdlProject getProject() {
        return getTestRunnable();
    }

    public List<TestSuiteRunner> getResults() {
        return new ArrayList<>();
    }
}
