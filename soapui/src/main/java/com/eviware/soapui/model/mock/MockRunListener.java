

package com.eviware.soapui.model.mock;

import com.eviware.soapui.model.iface.SoapUIListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Listener for MockRunner events
 *
 * @author ole.matzura
 */

public interface MockRunListener extends SoapUIListener {
    public void onMockRunnerStart(MockRunner mockRunner);

    public void onMockResult(MockResult result);

    public void onMockRunnerStop(MockRunner mockRunner);

    /**
     * Called before dispatching a request. If a MockResult is returned, further
     * dispatching is aborted and the returned result is used.
     *
     * @param runner
     * @param request
     * @param response
     * @return an optional MockResult, null if dispatching should move on as
     *         usual
     */

    public MockResult onMockRequest(MockRunner runner, HttpServletRequest request, HttpServletResponse response);
}
