

package com.eviware.soapui.model.mock;

import com.eviware.soapui.model.Releasable;

/**
 * The mock runner is responsible for setting up a server on a port. It listens to requests and dispatches them
 * to the correct target.
 *
 * @author ole.matzura
 */

public interface MockRunner extends MockDispatcher, Releasable {
    /**
     * Start this runner. If already started - do nothing.
     */
    public void start() throws Exception;

    /**
     * Stop this runner. If not running - do nothing.
     */
    public void stop();

    /**
     * @return true if this runner is running - false otherwise.
     */
    public boolean isRunning();

    /**
     * @return The MockRunContext for this runner. This includes references to the mock service and responses for
     *         this runner.
     */
    public MockRunContext getMockContext();
}
