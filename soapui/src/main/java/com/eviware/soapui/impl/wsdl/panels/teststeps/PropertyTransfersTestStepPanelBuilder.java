

package com.eviware.soapui.impl.wsdl.panels.teststeps;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.wsdl.teststeps.PropertyTransfersTestStep;
import com.eviware.soapui.ui.desktop.DesktopPanel;

import java.awt.Component;

/**
 * PanelBuilder for TransferResponseValuesTestStep
 *
 * @author Ole.Matzura
 */

public class PropertyTransfersTestStepPanelBuilder extends EmptyPanelBuilder<PropertyTransfersTestStep> {
    public PropertyTransfersTestStepPanelBuilder() {
    }

    public DesktopPanel buildDesktopPanel(PropertyTransfersTestStep testStep) {
        return new PropertyTransfersDesktopPanel(testStep);
    }

    public boolean hasDesktopPanel() {
        return true;
    }

    @Override
    public Component buildOverviewPanel(PropertyTransfersTestStep modelItem) {
        return buildDefaultProperties(modelItem, "PropertyTransfer Properties");
    }
}
