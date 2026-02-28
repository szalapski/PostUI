

package com.eviware.soapui.model.testsuite;

/**
 * Listener for assertion events.. should be added to core model
 *
 * @author Ole.Matzura
 */

public interface AssertionsListener {
    public void assertionAdded(TestAssertion assertion);

    public void assertionRemoved(TestAssertion assertion);

    public void assertionMoved(TestAssertion assertion, int ix, int offset);
}
