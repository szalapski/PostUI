

package com.eviware.soapui.model.testsuite;

/**
 * Context information for a testcase run session
 */

public interface TestCaseRunContext extends TestRunContext {
    public TestStep getCurrentStep();

    public int getCurrentStepIndex();

    public TestCaseRunner getTestRunner();

    public TestCase getTestCase();

    public Object getProperty(String testStep, String propertyName);
}
