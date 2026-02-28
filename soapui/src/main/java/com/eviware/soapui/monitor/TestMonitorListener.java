

package com.eviware.soapui.monitor;

import com.eviware.soapui.model.mock.MockRunner;
import com.eviware.soapui.model.testsuite.LoadTestRunner;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.security.SecurityTestRunner;

/**
 * Listener for TestMonitor events
 *
 * @author Ole.Matzura
 */

public interface TestMonitorListener {
    public void loadTestStarted(LoadTestRunner runner);

    public void loadTestFinished(LoadTestRunner runner);

    public void securityTestStarted(SecurityTestRunner runner);

    public void securityTestFinished(SecurityTestRunner runner);

    public void testCaseStarted(TestCaseRunner runner);

    public void testCaseFinished(TestCaseRunner runner);

    public void mockServiceStarted(MockRunner runner);

    public void mockServiceStopped(MockRunner runner);
}
