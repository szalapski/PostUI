

package com.eviware.soapui.impl.wsdl.panels.support;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.support.AbstractSubmitContext;
import com.eviware.soapui.model.testsuite.ProjectRunContext;
import com.eviware.soapui.model.testsuite.ProjectRunner;
import com.eviware.soapui.model.testsuite.TestRunner;

public class MockProjectRunContext extends AbstractSubmitContext<WsdlProject> implements ProjectRunContext {
    private final MockProjectRunner mockProjectRunner;

    public MockProjectRunContext(MockProjectRunner mockProjectRunner) {
        super(mockProjectRunner.getProject());
        this.mockProjectRunner = mockProjectRunner;
    }

    public WsdlProject getProject() {
        return getModelItem();
    }

    public ProjectRunner getProjectRunner() {
        return mockProjectRunner;
    }

    public TestRunner getTestRunner() {
        return mockProjectRunner;
    }

    public Object getProperty(String name) {
        return getProperties().get(name);
    }
}
