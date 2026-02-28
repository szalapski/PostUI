

package com.eviware.soapui.model.support;

import com.eviware.soapui.model.testsuite.TestCaseRunContext;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.model.testsuite.TestRunListener;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.model.testsuite.TestStepResult;

/**
 * Adapter for TestRunListener implementations
 *
 * @author Ole.Matzura
 */

public class TestRunListenerAdapter implements TestRunListener {

    public void beforeRun(TestCaseRunner testRunner, TestCaseRunContext runContext) {
    }

    public void beforeStep(TestCaseRunner testRunner, TestCaseRunContext runContext) {
    }

    public void afterStep(TestCaseRunner testRunner, TestCaseRunContext runContext, TestStepResult result) {
    }

    public void afterRun(TestCaseRunner testRunner, TestCaseRunContext runContext) {
    }

    public void beforeStep(TestCaseRunner testRunner, TestCaseRunContext runContext, TestStep testStep) {
    }
}
