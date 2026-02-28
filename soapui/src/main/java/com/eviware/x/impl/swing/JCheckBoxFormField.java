

package com.eviware.x.impl.swing;

import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JCheckBoxFormField extends AbstractSwingXFormField<JCheckBox> implements ChangeListener {
    public JCheckBoxFormField(String description) {
        super(new JCheckBox());
        getComponent().setText(description);
        getComponent().addChangeListener(this);
    }

    public void setValue(String value) {
        getComponent().setSelected(Boolean.parseBoolean(value));
    }

    public String getValue() {
        return Boolean.toString(getComponent().isSelected());
    }

    public void stateChanged(ChangeEvent e) {
        fireValueChanged(Boolean.toString(getComponent().isSelected()), null);
    }

    public boolean showLabel(String label) {
        return !label.equals(getComponent().getText());
    }

}
