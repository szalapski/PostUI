

package com.eviware.x.impl.swing;

import com.eviware.x.form.XFormTextField;
import org.jdesktop.swingx.JXTable;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import java.awt.Color;
import java.awt.Dimension;

public class JTableFormField extends AbstractSwingXFormField<JComponent> implements XFormTextField {
    private JScrollPane scrollPane;

    public JTableFormField(String description) {
        super(new JXTable());

        scrollPane = new JScrollPane(getTable());
        scrollPane.setPreferredSize(new Dimension(350, 200));
        getTable().setToolTipText(description);
        getTable().setHorizontalScrollEnabled(true);
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

    public JXTable getTable() {
        return (JXTable) super.getComponent();
    }

    public JComponent getComponent() {
        return scrollPane;
    }

    @Override
    public void setProperty(String name, Object value) {
        if ("tableModel".equals(name)) {
            getTable().setModel((TableModel) value);
        } else {
            super.setProperty(name, value);
        }
    }

    @Override
    public Object getProperty(String name) {
        if ("tableModel".equals(name)) {
            return getTable().getModel();
        } else {
            return super.getProperty(name);
        }
    }

    public void setValue(String value) {

    }

    public String getValue() {
        return null;
    }

    public void setWidth(int columns) {
    }

    @Override
    public boolean isMultiRow() {
        return true;
    }
}
