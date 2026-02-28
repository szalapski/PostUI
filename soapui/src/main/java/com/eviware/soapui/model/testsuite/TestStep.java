

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.TestModelItem;

/**
 * A TestStep in a TestCase
 *
 * @author Ole.Matzura
 */

public interface TestStep extends TestModelItem, ResultContainer {
    public final static String DISABLED_PROPERTY = TestStep.class.getName() + "@disabled";

    public TestCase getTestCase();

    public void prepare(TestCaseRunner testRunner, TestCaseRunContext testRunContext) throws Exception;

    public void finish(TestCaseRunner testRunner, TestCaseRunContext testRunContext);

    public boolean cancel();

    public TestStepResult run(TestCaseRunner testRunner, TestCaseRunContext testRunContext);

    public boolean isDisabled();

    public String getLabel();
}
