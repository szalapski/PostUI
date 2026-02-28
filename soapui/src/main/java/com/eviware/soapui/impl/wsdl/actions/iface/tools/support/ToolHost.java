

package com.eviware.soapui.impl.wsdl.actions.iface.tools.support;

/**
 * Host for running ToolRunners
 *
 * @author ole.matzura
 */

public interface ToolHost {
    public void run(ToolRunner runner) throws Exception;
}
