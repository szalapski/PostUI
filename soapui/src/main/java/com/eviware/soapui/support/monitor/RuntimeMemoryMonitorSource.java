

package com.eviware.soapui.support.monitor;

/**
 * @author Angelo De Caro
 */
public class RuntimeMemoryMonitorSource implements MonitorSource {

    private Runtime runtime = Runtime.getRuntime();

    public long getTotal() {
        return runtime.totalMemory();
    }

    public long getUsed() {
        return runtime.totalMemory() - runtime.freeMemory();
    }

}
