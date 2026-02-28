

package com.eviware.x.impl.swing;

import com.eviware.soapui.support.components.JFormComponent;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class JComponentFormField extends AbstractSwingXFormField<JPanel> {
    private JComponent component;

    public JComponentFormField(String label, String description) {
        super(new JPanel(new BorderLayout()));
        getComponent().setPreferredSize(new Dimension(400, 200));
    }

    public void setValue(String value) {
        if (component instanceof JFormComponent) {
            ((JFormComponent) component).setValue(value);
        }
    }

    public String getValue() {
        if (component instanceof JFormComponent) {
            return ((JFormComponent) component).getValue();
        } else {
            return null;
        }
    }

    @Override
    public void setProperty(String name, Object value) {
        if (name.equals("component")) {
            getComponent().removeAll();
            if (value != null) {
                getComponent().add((JComponent) value, BorderLayout.CENTER);
            }

            getComponent().revalidate();
            getComponent().getParent().repaint();
        } else if (name.equals("preferredSize")) {
            getComponent().setPreferredSize((Dimension) value);
            getComponent().setMaximumSize((Dimension) value);
            getComponent().setMinimumSize((Dimension) value);
            getComponent().setSize((Dimension) value);
        } else {
            super.setProperty(name, value);
        }
    }
}
