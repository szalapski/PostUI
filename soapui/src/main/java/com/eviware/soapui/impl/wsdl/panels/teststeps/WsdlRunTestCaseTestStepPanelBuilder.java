

package com.eviware.soapui.impl.wsdl.panels.teststeps;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlRunTestCaseTestStep;
import com.eviware.soapui.ui.desktop.DesktopPanel;

/**
 * PanelBuilder for WsdlGroovyTestStep
 *
 * @author Ole.Matzura
 */

public class WsdlRunTestCaseTestStepPanelBuilder extends EmptyPanelBuilder<WsdlRunTestCaseTestStep> {
    public WsdlRunTestCaseTestStepPanelBuilder() {
    }

    public DesktopPanel buildDesktopPanel(WsdlRunTestCaseTestStep testStep) {
        return new WsdlRunTestCaseStepDesktopPanel(testStep);
    }

    public boolean hasDesktopPanel() {
        return true;
    }
}
