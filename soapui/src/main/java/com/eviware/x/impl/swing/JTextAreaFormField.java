

package com.eviware.x.impl.swing;

import com.eviware.soapui.support.components.JUndoableTextArea;
import com.eviware.x.form.XFormTextField;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class JTextAreaFormField extends AbstractSwingXFormField<JComponent> implements XFormTextField {
    private JScrollPane scrollPane;

    public JTextAreaFormField() {
        super(new JUndoableTextArea());

        scrollPane = new JScrollPane(super.getComponent());
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

    public JTextArea getTextArea() {
        return (JTextArea) super.getComponent();
    }

    public JComponent getComponent() {
        return scrollPane;
    }

    public void setValue(String value) {
        getTextArea().setText(value);
    }

    public String getValue() {
        return getTextArea().getText();
    }

    public void setWidth(int columns) {
        getTextArea().setColumns(columns);
    }

    public void setEditable(boolean value) {
        getTextArea().setEditable(value);
    }

    @Override
    public boolean isMultiRow() {
        return true;
    }
}
