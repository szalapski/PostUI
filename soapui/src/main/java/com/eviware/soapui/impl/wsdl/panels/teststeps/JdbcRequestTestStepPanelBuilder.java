

package com.eviware.soapui.impl.wsdl.panels.teststeps;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.wsdl.teststeps.JdbcRequestTestStep;
import com.eviware.soapui.support.components.JPropertiesTable;
import com.eviware.soapui.ui.desktop.DesktopPanel;

import java.awt.Component;

/**
 * PanelBuilder for JdbcRequestTestStep
 *
 * @author dragica.soldo
 */

public class JdbcRequestTestStepPanelBuilder extends EmptyPanelBuilder<JdbcRequestTestStep> {
    public JdbcRequestTestStepPanelBuilder() {
    }

    public DesktopPanel buildDesktopPanel(JdbcRequestTestStep testStep) {
        return new JdbcRequestTestStepDesktopPanel(testStep);
    }

    public boolean hasDesktopPanel() {
        return true;
    }

    @Override
    public Component buildOverviewPanel(JdbcRequestTestStep modelItem) {
        JPropertiesTable<JdbcRequestTestStep> table = buildDefaultProperties(modelItem, "JdbcRequestTestStep Properties");
        table.addProperty("Max Rows", "maxRows", true);
        table.addProperty("Query Timeout", "queryTimeout", true);
        table.addProperty("Fetch Size", "fetchSize", true);
        table.addProperty("Discard Response", "discardResponse", JPropertiesTable.BOOLEAN_OPTIONS);
        return table;
    }
}
