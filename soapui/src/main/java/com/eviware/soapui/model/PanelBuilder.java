

package com.eviware.soapui.model;

import com.eviware.soapui.ui.desktop.DesktopPanel;

import java.awt.Component;

/**
 * Behaviour for building ModelItem-related UI panels
 *
 * @author Ole.Matzura
 */

public interface PanelBuilder<T extends ModelItem> {
    public boolean hasOverviewPanel();

    public Component buildOverviewPanel(T modelItem);

    public boolean hasDesktopPanel();

    public DesktopPanel buildDesktopPanel(T modelItem);
}
