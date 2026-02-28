

package com.eviware.soapui.model.support;

import com.eviware.soapui.model.mock.MockResult;
import com.eviware.soapui.model.mock.MockRunListener;
import com.eviware.soapui.model.mock.MockRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Adapter for MockRunListeners
 *
 * @author ole.matzura
 */

public class MockRunListenerAdapter implements MockRunListener {
    public void onMockRunnerStart(MockRunner mockRunner) {
    }

    public void onMockRunnerStop(MockRunner mockRunner) {
    }

    public void onMockResult(MockResult result) {
    }

    public MockResult onMockRequest(MockRunner runner, HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
