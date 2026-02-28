

package com.eviware.soapui.impl.wsdl.panels.teststeps;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlPropertiesTestStep;
import com.eviware.soapui.support.components.JPropertiesTable;
import com.eviware.soapui.ui.desktop.DesktopPanel;

import javax.swing.JPanel;

/**
 * PanelBuilder for WsdlPropertiesTestStep
 *
 * @author Ole.Matzura
 */

public class PropertiesStepPanelBuilder extends EmptyPanelBuilder<WsdlPropertiesTestStep> {
    public PropertiesStepPanelBuilder() {
    }

    public DesktopPanel buildDesktopPanel(WsdlPropertiesTestStep testStep) {
        return new PropertiesStepDesktopPanel(testStep);
    }

    public boolean hasDesktopPanel() {
        return true;
    }

    public JPanel buildOverviewPanel(WsdlPropertiesTestStep testStep) {
        JPropertiesTable<WsdlPropertiesTestStep> table = new JPropertiesTable<>(
                "PropertiesStep Properties");

        table.addProperty("Name", "name", true);
        table.addProperty("Description", "description", true);
        table.addProperty("Create Missing on Load", "createMissingOnLoad", JPropertiesTable.BOOLEAN_OPTIONS);
        table.addProperty("Save before Load", "saveFirst", JPropertiesTable.BOOLEAN_OPTIONS);
        table.addProperty("Discard Values on Save", "discardValuesOnSave", JPropertiesTable.BOOLEAN_OPTIONS);
        table.setPropertyObject(testStep);

        return table;
    }

    public boolean hasOverviewPanel() {
        return true;
    }
}
