

package com.eviware.soapui.impl.wsdl.actions.iface.tools.support;

import com.eviware.soapui.model.ModelItem;

/**
 * Runner for Tool-related utilities
 *
 * @author ole.matzura
 */

public interface ToolRunner extends Runnable {
    public void setContext(RunnerContext context);

    public boolean isRunning();

    public boolean canCancel();

    public boolean showLog();

    public void cancel();

    public String getName();

    public ModelItem getModelItem();

    public String getDescription();
}
