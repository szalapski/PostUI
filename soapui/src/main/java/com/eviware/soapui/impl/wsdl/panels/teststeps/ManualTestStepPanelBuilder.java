

package com.eviware.soapui.impl.wsdl.panels.teststeps;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.wsdl.teststeps.ManualTestStep;
import com.eviware.soapui.support.components.JPropertiesTable;
import com.eviware.soapui.ui.desktop.DesktopPanel;

import java.awt.Component;

/**
 * PanelBuilder for WsdlGotoTestStep
 *
 * @author Ole.Matzura
 */

public class ManualTestStepPanelBuilder extends EmptyPanelBuilder<ManualTestStep> {
    public ManualTestStepPanelBuilder() {
    }

    @Override
    public Component buildOverviewPanel(ManualTestStep modelItem) {
        JPropertiesTable<ManualTestStep> table = buildDefaultProperties(modelItem, "Step Properties");
        return table;
    }

    @Override
    public DesktopPanel buildDesktopPanel(ManualTestStep modelItem) {
        return new ManualTestStepDesktopPanel(modelItem);
    }

    @Override
    public boolean hasDesktopPanel() {
        return true;
    }
}
