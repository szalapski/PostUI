

package com.eviware.soapui.model.testsuite;

/**
 * Context information for a testcase run session
 */

public interface TestSuiteRunContext extends TestRunContext {
    public TestCase getCurrentTestCase();

    public int getCurrentTestCaseIndex();

    public TestSuiteRunner getTestSuiteRunner();

    public TestSuite getTestSuite();
}
