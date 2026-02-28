

package com.eviware.soapui.support.log;

import javax.swing.JComponent;

/**
 * JTabbedPane that displays Log4J output in different tabs
 *
 * @author Ole.Matzura
 */

public interface Log4JMonitor {
    public JLogList addLogArea(String title, String loggerName, boolean isDefault);

    public void logEvent(Object msg);

    public JLogList getLogArea(String title);

    public boolean hasLogArea(String loggerName);

    public JComponent getComponent();

    public JLogList getCurrentLog();

    public void setCurrentLog(JLogList lastLog);

    public boolean removeLogArea(String loggerName);
}
