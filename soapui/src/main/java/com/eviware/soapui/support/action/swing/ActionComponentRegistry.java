

package com.eviware.soapui.support.action.swing;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.action.SoapUIAction;

import javax.swing.JComponent;
import java.util.HashMap;
import java.util.Map;

public class ActionComponentRegistry {
    static public <T extends ModelItem> JComponent buildActionComponent(SoapUIAction<T> action, T modelItem) {
        if (factories.containsKey(action.getId())) {
            return factories.get(action.getId()).buildActionComponent(action, modelItem);
        }

        return null;
    }

    private static Map<String, ActionComponentFactory> factories = new HashMap<>();

    static {
    }
}
