

package com.eviware.soapui.ui.desktop;

/**
 * Listener for Desktop-related events
 *
 * @author Ole.Matzura
 */

public interface DesktopListener {
    public void desktopPanelSelected(DesktopPanel desktopPanel);

    public void desktopPanelCreated(DesktopPanel desktopPanel);

    public void desktopPanelClosed(DesktopPanel desktopPanel);
}
