

package com.eviware.soapui.impl.wsdl.panels.support;

import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.model.testsuite.TestSuiteRunner;

import java.util.ArrayList;
import java.util.List;

public class MockTestSuiteRunner extends AbstractMockTestRunner<WsdlTestSuite> implements TestSuiteRunner {
    public MockTestSuiteRunner(WsdlTestSuite testSuite) {
        super(testSuite, null);
        setRunContext(new MockTestSuiteRunContext(this));
    }

    public List<TestCaseRunner> getResults() {
        return new ArrayList<>();
    }

    public TestSuite getTestSuite() {
        return getTestRunnable();
    }
}
