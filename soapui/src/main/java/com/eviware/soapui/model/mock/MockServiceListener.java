

package com.eviware.soapui.model.mock;

/**
 * Listener for MockService-events
 *
 * @author Ole.Matzura
 */

public interface MockServiceListener {
    void mockOperationAdded(MockOperation operation);

    void mockOperationRemoved(MockOperation operation);

    void mockResponseAdded(MockResponse request);

    void mockResponseRemoved(MockResponse request);
}
