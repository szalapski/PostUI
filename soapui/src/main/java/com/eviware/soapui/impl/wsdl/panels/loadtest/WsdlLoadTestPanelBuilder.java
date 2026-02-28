

package com.eviware.soapui.impl.wsdl.panels.loadtest;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.wsdl.loadtest.WsdlLoadTest;
import com.eviware.soapui.ui.desktop.DesktopPanel;

/**
 * PanelBuilder for LoadTests
 *
 * @author Ole.Matzura
 */

public class WsdlLoadTestPanelBuilder<T extends WsdlLoadTest> extends EmptyPanelBuilder<T> {
    public WsdlLoadTestPanelBuilder() {
    }

    public DesktopPanel buildDesktopPanel(T loadTest) {
        return new WsdlLoadTestDesktopPanel(loadTest);
    }

    public boolean hasDesktopPanel() {
        return true;
    }
}
