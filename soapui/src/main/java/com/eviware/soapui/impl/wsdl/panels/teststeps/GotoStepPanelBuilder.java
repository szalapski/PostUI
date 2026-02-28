

package com.eviware.soapui.impl.wsdl.panels.teststeps;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlGotoTestStep;
import com.eviware.soapui.ui.desktop.DesktopPanel;

/**
 * PanelBuilder for WsdlGotoTestStep
 *
 * @author Ole.Matzura
 */

public class GotoStepPanelBuilder extends EmptyPanelBuilder<WsdlGotoTestStep> {
    public GotoStepPanelBuilder() {
    }

    public DesktopPanel buildDesktopPanel(WsdlGotoTestStep testStep) {
        return new GotoStepDesktopPanel(testStep);
    }

    public boolean hasDesktopPanel() {
        return true;
    }
}
