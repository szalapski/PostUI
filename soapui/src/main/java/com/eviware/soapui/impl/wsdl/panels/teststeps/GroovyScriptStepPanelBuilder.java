

package com.eviware.soapui.impl.wsdl.panels.teststeps;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlGroovyScriptTestStep;
import com.eviware.soapui.ui.desktop.DesktopPanel;

/**
 * PanelBuilder for WsdlGroovyTestStep
 *
 * @author Ole.Matzura
 */

public class GroovyScriptStepPanelBuilder extends EmptyPanelBuilder<WsdlGroovyScriptTestStep> {
    public GroovyScriptStepPanelBuilder() {
    }

    public DesktopPanel buildDesktopPanel(WsdlGroovyScriptTestStep testStep) {
        return new GroovyScriptStepDesktopPanel(testStep);
    }

    public boolean hasDesktopPanel() {
        return true;
    }
}
