

package com.eviware.soapui.support;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public abstract class ListDataChangeListener implements ListDataListener {
    public void contentsChanged(ListDataEvent e) {
        dataChanged((ListModel) e.getSource());
    }

    public void intervalAdded(ListDataEvent e) {
        dataChanged((ListModel) e.getSource());
    }

    public void intervalRemoved(ListDataEvent e) {
        dataChanged((ListModel) e.getSource());
    }

    public abstract void dataChanged(ListModel model);
}
