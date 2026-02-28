

package com.eviware.soapui.model.testsuite;

/**
 * Context information for a loadtest run session
 */

public interface LoadTestRunContext extends TestRunContext {
    public LoadTestRunner getLoadTestRunner();
}
