

package com.eviware.soapui.security;

import com.eviware.soapui.model.security.SecurityScan;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.security.result.SecurityScanResult;

/**
 * SecurityTestRunner
 *
 * @author SoapUI team
 */
public interface SecurityTestRunner extends TestRunner {
    public SecurityTest getSecurityTest();

    public SecurityScanResult runTestStepSecurityScan(SecurityTestRunContext runContext, TestStep testStep,
                                                      SecurityScan securityScan);

    // Removed the rest cause I don't think we need them, since
    // SecurityTestRunnerImpl extends WsdlTestCaseRunner
    /**
     * Returns the progress of the security test as a value between 0 and 1.
     * Progress is measured depending on the LoadTest limit configuration
     */

    // public float getProgress();

    /**
     * Confusing but unfortunately necessary; isStopped will return false until
     * the securitytest has called all handlers, etc.. the status will be set to
     * FINISHED before that.
     *
     * @return
     */

    // public boolean hasStopped();

}
