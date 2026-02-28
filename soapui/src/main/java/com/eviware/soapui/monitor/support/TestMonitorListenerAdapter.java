

package com.eviware.soapui.monitor.support;

import com.eviware.soapui.model.mock.MockRunner;
import com.eviware.soapui.model.testsuite.LoadTestRunner;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.monitor.TestMonitorListener;
import com.eviware.soapui.security.SecurityTestRunner;

/**
 * Adapter for TestMonitorListener implementations
 *
 * @author Ole.Matzura
 */

public class TestMonitorListenerAdapter implements TestMonitorListener {
    public void loadTestStarted(LoadTestRunner runner) {
    }

    public void loadTestFinished(LoadTestRunner runner) {
    }

    public void securityTestStarted(SecurityTestRunner runner) {
    }

    public void securityTestFinished(SecurityTestRunner runner) {
    }

    public void testCaseStarted(TestCaseRunner runner) {
    }

    public void testCaseFinished(TestCaseRunner runner) {
    }

    public void mockServiceStarted(MockRunner runner) {
    }

    public void mockServiceStopped(MockRunner runner) {
    }
}
