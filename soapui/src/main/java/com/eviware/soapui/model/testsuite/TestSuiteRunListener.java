

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.iface.SoapUIListener;

/**
 * Listener for TestRun-related events, schedule events will only be triggered
 * for LoadTest runs.
 *
 * @author Ole.Matzura
 */

public interface TestSuiteRunListener extends SoapUIListener {
    public void beforeRun(TestSuiteRunner testRunner, TestSuiteRunContext runContext);

    public void afterRun(TestSuiteRunner testRunner, TestSuiteRunContext runContext);

    public void beforeTestCase(TestSuiteRunner testRunner, TestSuiteRunContext runContext, TestCase testCase);

    public void afterTestCase(TestSuiteRunner testRunner, TestSuiteRunContext runContext, TestCaseRunner testCaseRunner);
}
