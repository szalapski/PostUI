

package com.eviware.soapui.support.components;

import javax.swing.Icon;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import java.awt.FontMetrics;
import java.awt.Insets;

public class VerticalMetalTabbedPaneUI extends MetalTabbedPaneUI {
    protected void installDefaults() {
        super.installDefaults();

        textIconGap = 0;
        tabInsets = new Insets(0, 0, 0, 0);
    }

    protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
        Icon icon = getIconForTab(tabIndex);
        return icon == null ? 2 : icon.getIconWidth() + 2;
    }
}
