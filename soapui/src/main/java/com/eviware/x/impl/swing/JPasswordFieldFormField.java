

package com.eviware.x.impl.swing;

import com.eviware.x.form.XFormTextField;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import java.awt.Color;

public class JPasswordFieldFormField extends AbstractSwingXFormField<JPasswordField> implements XFormTextField {
    public JPasswordFieldFormField() {
        super(new JPasswordField(15));
    }

    public void setRequired(boolean required, String message) {
        super.setRequired(required, message);

        if (required) {
            getComponent().setBorder(
                    BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.RED),
                            BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        } else {
            getComponent().setBorder(
                    BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY),
                            BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        }
    }

    public void setValue(String value) {
        getComponent().setText(value);
    }

    public String getValue() {
        return new String(getComponent().getPassword());
    }

    public void setWidth(int columns) {
        getComponent().setColumns(columns);
    }
}
