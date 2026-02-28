

package com.eviware.soapui.impl.wsdl.actions.iface;

import com.eviware.soapui.support.UISupport;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.ActionEvent;

/**
 * Utility class for creating Swing Actions for ModelItems
 *
 * @author ole.matzura
 */

public abstract class AbstractSwingAction<T extends Object> extends AbstractAction {
    private T modelItem;
    private final String name;

    public AbstractSwingAction(String name, String description) {
        super(name);
        this.name = name;
        this.modelItem = null;

        putValue(Action.SHORT_DESCRIPTION, description);
    }

    public AbstractSwingAction(String name, String description, T modelItem) {
        super(name);
        this.name = name;
        this.modelItem = modelItem;

        putValue(Action.SHORT_DESCRIPTION, description);
    }

    public AbstractSwingAction(String name, String description, String iconUrl) {
        super(name);
        this.name = name;
        this.modelItem = null;

        putValue(Action.SHORT_DESCRIPTION, description);
        putValue(Action.SMALL_ICON, UISupport.createImageIcon(iconUrl));
    }

    public AbstractSwingAction(String name, String description, String iconUrl, T modelItem) {
        super(name);
        this.name = name;
        this.modelItem = modelItem;

        putValue(Action.SHORT_DESCRIPTION, description);
        putValue(Action.SMALL_ICON, UISupport.createImageIcon(iconUrl));
    }

    public void actionPerformed(ActionEvent arg0) {
        actionPerformed(arg0, modelItem);
    }

    public String getName() {
        return name;
    }

    public abstract void actionPerformed(ActionEvent arg0, T modelItem2);

    public T getModelItem() {
        return modelItem;
    }
}
