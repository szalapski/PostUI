

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.security.SecurityTest;

/**
 * Listener for TestSuite-related events
 *
 * @author Ole.Matzura
 */

public interface TestSuiteListener {
    void testCaseAdded(TestCase testCase);

    void testCaseRemoved(TestCase testCase);

    void testCaseMoved(TestCase testCase, int index, int offset);

    void loadTestAdded(LoadTest loadTest);

    void loadTestRemoved(LoadTest loadTest);

    void testStepAdded(TestStep testStep, int index);

    void testStepRemoved(TestStep testStep, int index);

    void testStepMoved(TestStep testStep, int fromIndex, int offset);

    void securityTestAdded(SecurityTest securityTest);

    void securityTestRemoved(SecurityTest securityTest);
}
