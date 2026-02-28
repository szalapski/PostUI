

package com.eviware.soapui.impl.wsdl.panels.testsuite;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.support.components.JPropertiesTable;
import com.eviware.soapui.ui.desktop.DesktopPanel;

import java.awt.Component;

/**
 * PanelBuilder for WsdlTestSuite
 *
 * @author Ole.Matzura
 */

public class WsdlTestSuitePanelBuilder<T extends WsdlTestSuite> extends EmptyPanelBuilder<T> {
    public WsdlTestSuitePanelBuilder() {
    }

    public DesktopPanel buildDesktopPanel(T testSuite) {
        return new WsdlTestSuiteDesktopPanel(testSuite);
    }

    public boolean hasDesktopPanel() {
        return true;
    }

    public Component buildOverviewPanel(T modelItem) {
        JPropertiesTable<WsdlTestSuite> table = new JPropertiesTable<>("TestSuite Properties", modelItem);

        table.addProperty("Name", "name", true);

        table.setPropertyObject(modelItem);

        return table;
    }
}
