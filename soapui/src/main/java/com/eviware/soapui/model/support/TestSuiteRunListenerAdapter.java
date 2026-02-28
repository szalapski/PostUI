

package com.eviware.soapui.model.support;

import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.model.testsuite.TestSuiteRunContext;
import com.eviware.soapui.model.testsuite.TestSuiteRunListener;
import com.eviware.soapui.model.testsuite.TestSuiteRunner;

public class TestSuiteRunListenerAdapter implements TestSuiteRunListener {

    public void afterRun(TestSuiteRunner testRunner, TestSuiteRunContext runContext) {
    }

    public void afterTestCase(TestSuiteRunner testRunner, TestSuiteRunContext runContext, TestCaseRunner testCaseRunner) {
    }

    public void beforeRun(TestSuiteRunner testRunner, TestSuiteRunContext runContext) {
    }

    public void beforeTestCase(TestSuiteRunner testRunner, TestSuiteRunContext runContext, TestCase testCase) {
    }

}
