

package com.eviware.x.impl.swing;

import javax.swing.JLabel;

public class JLabelFormField extends AbstractSwingXFormField<JLabel> {
    public JLabelFormField() {
        this("");
    }

    public JLabelFormField(String label) {
        super(new JLabel());
        getComponent().setText(label);
    }

    public void setValue(String value) {
        getComponent().setText(value);
    }

    public String getValue() {
        return getComponent().getText();
    }

    public boolean showLabel() {
        return false;
    }
}
