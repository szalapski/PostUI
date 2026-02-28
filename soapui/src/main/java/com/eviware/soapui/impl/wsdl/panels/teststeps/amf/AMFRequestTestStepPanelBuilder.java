

package com.eviware.soapui.impl.wsdl.panels.teststeps.amf;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.wsdl.teststeps.AMFRequestTestStep;
import com.eviware.soapui.support.components.JPropertiesTable;
import com.eviware.soapui.ui.desktop.DesktopPanel;

import java.awt.Component;

/**
 * PanelBuilder for AMFRequestTestStep
 *
 * @author nebojsa.tasic
 */

public class AMFRequestTestStepPanelBuilder extends EmptyPanelBuilder<AMFRequestTestStep> {
    public AMFRequestTestStepPanelBuilder() {
    }

    public DesktopPanel buildDesktopPanel(AMFRequestTestStep testStep) {
        return new AMFRequestTestStepDesktopPanel(testStep);
    }

    public boolean hasDesktopPanel() {
        return true;
    }

    @Override
    public Component buildOverviewPanel(AMFRequestTestStep modelItem) {
        JPropertiesTable<AMFRequestTestStep> table = buildDefaultProperties(modelItem, "AMFRequestTestStep Properties");
        table.addProperty("Discard Response", "discardResponse", JPropertiesTable.BOOLEAN_OPTIONS);
        return table;
    }
}
