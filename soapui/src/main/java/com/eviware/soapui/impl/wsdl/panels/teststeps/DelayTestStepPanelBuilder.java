

package com.eviware.soapui.impl.wsdl.panels.teststeps;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlDelayTestStep;
import com.eviware.soapui.support.components.JPropertiesTable;

import java.awt.Component;

/**
 * PanelBuilder for WsdlGotoTestStep
 *
 * @author Ole.Matzura
 */

public class DelayTestStepPanelBuilder extends EmptyPanelBuilder<WsdlDelayTestStep> {
    public DelayTestStepPanelBuilder() {
    }

    @Override
    public Component buildOverviewPanel(WsdlDelayTestStep modelItem) {
        JPropertiesTable<WsdlDelayTestStep> table = buildDefaultProperties(modelItem, "Delay Properties");
        table.addProperty("Delay", "delayString", true);
        return table;
    }
}
