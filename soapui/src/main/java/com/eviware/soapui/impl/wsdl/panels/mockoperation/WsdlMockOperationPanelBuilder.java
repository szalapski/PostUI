

package com.eviware.soapui.impl.wsdl.panels.mockoperation;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.wsdl.mock.WsdlMockOperation;
import com.eviware.soapui.support.components.JPropertiesTable;
import com.eviware.soapui.ui.desktop.DesktopPanel;

import java.awt.Component;

/**
 * PanelBuilder for WsdlMockOperation
 *
 * @author Ole.Matzura
 */

public class WsdlMockOperationPanelBuilder extends EmptyPanelBuilder<WsdlMockOperation> {
    public boolean hasOverviewPanel() {
        return true;
    }

    public Component buildOverviewPanel(WsdlMockOperation mockOperation) {
        JPropertiesTable<WsdlMockOperation> table = new JPropertiesTable<>("Mock Operation");
        table = new JPropertiesTable<>("MockOperation Properties");
        table.addProperty("Name", "name", true);
        table.addProperty("Description", "description", true);
        table.addProperty("WSDL Operation", "wsdlOperationName", false);
        table.addProperty("Dispatch Style", "dispatchStyle", false);
        table.setPropertyObject(mockOperation);

        return table;
    }

    @Override
    public DesktopPanel buildDesktopPanel(WsdlMockOperation mockOperation) {
        return new WsdlMockOperationDesktopPanel(mockOperation);
    }

    @Override
    public boolean hasDesktopPanel() {
        return true;
    }
}
