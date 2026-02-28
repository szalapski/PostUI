

package com.eviware.x.impl.swing;

import com.eviware.soapui.support.UISupport;
import com.eviware.x.form.AbstractXFormField;

import javax.swing.JComponent;
import java.awt.Dimension;

public abstract class AbstractSwingXFormField<T extends JComponent> extends AbstractXFormField<T> {
    private T component;

    public AbstractSwingXFormField(T component) {
        this.component = component;
    }

    public T getComponent() {
        return component;
    }

    public void setToolTip(String tooltip) {
        component.setToolTipText(tooltip);
        component.getAccessibleContext().setAccessibleDescription(tooltip);
    }

    public boolean isEnabled() {
        return component.isEnabled();
    }

    public void setEnabled(boolean enabled) {
        component.setEnabled(enabled);
    }

    public void setProperty(String name, Object value) {
        if (name.equals("dimension")) {
            UISupport.setFixedSize(getComponent(), (Dimension) value);
        }
    }
}
