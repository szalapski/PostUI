

package com.eviware.soapui.impl.wsdl.actions.iface.tools.support;

/**
 * Context information for a ToolRunner
 *
 * @author ole.matzura
 */

public interface RunnerContext {
    enum RunnerStatus {
        RUNNING, FINISHED, ERROR
    }

    public void log(String msg);

    public void logError(String msg);

    public void setStatus(RunnerStatus status);

    public void disposeContext();

    public RunnerStatus getStatus();

    public String getTitle();
}
