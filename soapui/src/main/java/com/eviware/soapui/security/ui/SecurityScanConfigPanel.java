

package com.eviware.soapui.security.ui;

import com.eviware.soapui.support.components.SimpleForm;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public abstract class SecurityScanConfigPanel extends JPanel {
    protected SimpleForm form;

    public SecurityScanConfigPanel(BorderLayout borderLayout) {
        super(borderLayout);
    }

    public abstract void save();
}
