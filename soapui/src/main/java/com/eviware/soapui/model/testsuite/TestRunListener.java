

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.iface.SoapUIListener;

/**
 * Listener for TestRun-related events, schedule events will only be triggered
 * for LoadTest runs.
 *
 * @author Ole.Matzura
 */

public interface TestRunListener extends SoapUIListener {
    public void beforeRun(TestCaseRunner testRunner, TestCaseRunContext runContext);

    public void afterRun(TestCaseRunner testRunner, TestCaseRunContext runContext);

    /**
     * @deprecated use
     *             {@link #beforeStep(TestCaseRunner, TestCaseRunContext, TestStep)}
     *             instead
     */
    @Deprecated
    public void beforeStep(TestCaseRunner testRunner, TestCaseRunContext runContext);

    public void beforeStep(TestCaseRunner testRunner, TestCaseRunContext runContext, TestStep testStep);

    public void afterStep(TestCaseRunner testRunner, TestCaseRunContext runContext, TestStepResult result);
}
