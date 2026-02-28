

package com.eviware.soapui.model.support;

import com.eviware.soapui.model.mock.MockOperation;
import com.eviware.soapui.model.mock.MockResponse;
import com.eviware.soapui.model.mock.MockServiceListener;

/**
 * Adapter for MockServiceListeners
 *
 * @author ole.matzura
 */

public class MockServiceListenerAdapter implements MockServiceListener {
    public void mockOperationAdded(MockOperation operation) {
    }

    public void mockOperationRemoved(MockOperation operation) {
    }

    public void mockResponseAdded(MockResponse request) {
    }

    public void mockResponseRemoved(MockResponse request) {
    }
}
