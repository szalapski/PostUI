

package com.eviware.soapui.model.support;

import com.eviware.soapui.model.testsuite.LoadTestRunContext;
import com.eviware.soapui.model.testsuite.LoadTestRunListener;
import com.eviware.soapui.model.testsuite.LoadTestRunner;
import com.eviware.soapui.model.testsuite.TestCaseRunContext;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.model.testsuite.TestStepResult;

/**
 * Adapter for LoadTestRunListener implementations
 *
 * @author Ole.Matzura
 */

public class LoadTestRunListenerAdapter implements LoadTestRunListener {
    public void beforeLoadTest(LoadTestRunner loadTestRunner, LoadTestRunContext context) {
    }

    public void beforeTestCase(LoadTestRunner loadTestRunner, LoadTestRunContext context, TestCaseRunner testRunner,
                               TestCaseRunContext runContext) {
    }

    public void beforeTestStep(LoadTestRunner loadTestRunner, LoadTestRunContext context, TestCaseRunner testRunner,
                               TestCaseRunContext runContext, TestStep testStep) {
    }

    public void afterTestStep(LoadTestRunner loadTestRunner, LoadTestRunContext context, TestCaseRunner testRunner,
                              TestCaseRunContext runContext, TestStepResult testStepResult) {
    }

    public void afterTestCase(LoadTestRunner loadTestRunner, LoadTestRunContext context, TestCaseRunner testRunner,
                              TestCaseRunContext runContext) {
    }

    public void afterLoadTest(LoadTestRunner loadTestRunner, LoadTestRunContext context) {
    }

    public void loadTestStarted(LoadTestRunner loadTestRunner, LoadTestRunContext context) {
    }

    public void loadTestStopped(LoadTestRunner loadTestRunner, LoadTestRunContext context) {
    }

}
