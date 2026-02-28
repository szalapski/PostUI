

package com.eviware.soapui.security.panels;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.security.SecurityTest;
import com.eviware.soapui.support.components.JPropertiesTable;
import com.eviware.soapui.ui.desktop.DesktopPanel;

import java.awt.Component;

/**
 * PanelBuilder for SecurityTests
 *
 * @author dragica.soldo
 */

public class SecurityTestPanelBuilder<T extends SecurityTest> extends EmptyPanelBuilder<T> {
    public SecurityTestPanelBuilder() {
    }

    public DesktopPanel buildDesktopPanel(T securityTest) {
        return new SecurityTestDesktopPanel(securityTest);
    }

    public boolean hasDesktopPanel() {
        return true;
    }

    public Component buildOverviewPanel(T modelItem) {
        JPropertiesTable<SecurityTest> table = new JPropertiesTable<>("SecurityTest Properties", modelItem);

        table.addProperty("Name", "name", true);

        table.setPropertyObject(modelItem);

        return table;
    }
}
