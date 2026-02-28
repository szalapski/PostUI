

package com.eviware.soapui.model.support;

import com.eviware.soapui.model.testsuite.LoadTest;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.model.testsuite.TestSuiteListener;
import com.eviware.soapui.security.SecurityTest;

/**
 * Adapter for TestSuiteListener implementations
 *
 * @author Ole.Matzura
 */

public class TestSuiteListenerAdapter implements TestSuiteListener {
    public void testCaseAdded(TestCase testCase) {
    }

    public void testCaseRemoved(TestCase testCase) {
    }

    public void testStepAdded(TestStep testStep, int index) {
    }

    public void testStepRemoved(TestStep testStep, int index) {
    }

    public void loadTestAdded(LoadTest loadTest) {
    }

    public void loadTestRemoved(LoadTest loadTest) {
    }

    public void securityTestAdded(SecurityTest securityTest) {
    }

    public void securityTestRemoved(SecurityTest securityTest) {
    }

    public void testStepMoved(TestStep testStep, int fromIndex, int offset) {
    }

    public void testCaseMoved(TestCase testCase, int index, int offset) {
    }
}
