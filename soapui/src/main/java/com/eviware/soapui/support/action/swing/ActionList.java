

package com.eviware.soapui.support.action.swing;

import javax.swing.Action;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * A simple list of actions
 *
 * @author Ole.Matzura
 */

public interface ActionList {
    public int getActionCount();

    public Action getActionAt(int index);

    public Action getDefaultAction();

    public boolean hasDefaultAction();

    public void performDefaultAction(ActionEvent event);

    public void addAction(Action action);

    public void addSeparator();

    public void insertAction(Action action, int index);

    public void insertSeparator(int index);

    public String getLabel();

    public void clear();

    public void dispatchKeyEvent(KeyEvent e);

    public void addActions(ActionList defaultActions);

    public void setDefaultAction(Action action);

    public void removeAction(int index);
}
