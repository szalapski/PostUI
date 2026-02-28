

package com.eviware.soapui.impl.wsdl.panels.testcase;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.support.components.JPropertiesTable;
import com.eviware.soapui.ui.desktop.DesktopPanel;

import java.awt.Component;

/**
 * PanelBuilder for WsdlTestCase
 *
 * @author Ole.Matzura
 */

public class WsdlTestCasePanelBuilder<T extends WsdlTestCase> extends EmptyPanelBuilder<T> {
    public WsdlTestCasePanelBuilder() {
    }

    public DesktopPanel buildDesktopPanel(T testCase) {
        return new WsdlTestCaseDesktopPanel(testCase);
    }

    public boolean hasDesktopPanel() {
        return true;
    }

    public Component buildOverviewPanel(T modelItem) {
        JPropertiesTable<WsdlTestCase> table = new JPropertiesTable<>("TestCase Properties", modelItem);

        table.addProperty("Name", "name", true);

        table.setPropertyObject(modelItem);

        return table;
    }
}
