

package com.eviware.soapui.impl.wsdl.loadtest;

/**
 * WsdlLoadTest specific events.
 *
 * @author Ole.Matzura
 */

public interface LoadTestListener {
    public void assertionAdded(LoadTestAssertion assertion);

    public void assertionRemoved(LoadTestAssertion assertion);
}
