

package com.eviware.soapui.impl.support.definition.support;

import com.eviware.soapui.impl.support.definition.DefinitionLoader;
import com.eviware.x.dialogs.XProgressMonitor;

public abstract class AbstractDefinitionLoader implements DefinitionLoader {
    protected XProgressMonitor monitor;
    protected int progressIndex;

    public void setProgressMonitor(XProgressMonitor monitor, int progressIndex) {
        this.monitor = monitor;
        this.progressIndex = progressIndex;
    }

    public void setProgressInfo(String info) {
        if (monitor != null) {
            monitor.setProgress(0, info);
        }
    }

    public boolean abort() {
        return false;
    }

    public boolean isAborted() {
        return false;
    }
}
