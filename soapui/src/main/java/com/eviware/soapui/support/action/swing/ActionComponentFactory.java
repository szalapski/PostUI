

package com.eviware.soapui.support.action.swing;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.action.SoapUIAction;

import javax.swing.JComponent;

public interface ActionComponentFactory {
    public abstract JComponent buildActionComponent(SoapUIAction<?> action, ModelItem modelItem);
}
