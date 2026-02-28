

package com.eviware.soapui.model.testsuite;

import java.util.List;

public interface TestSuiteRunner extends TestRunner {
    public TestSuite getTestSuite();

    public List<TestCaseRunner> getResults();
}
