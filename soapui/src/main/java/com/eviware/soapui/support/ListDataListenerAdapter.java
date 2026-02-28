

package com.eviware.soapui.support;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public abstract class ListDataListenerAdapter implements ListDataListener {
    public void contentsChanged(ListDataEvent e) {
        update(e);
    }

    public void intervalAdded(ListDataEvent e) {
        update(e);
    }

    public void intervalRemoved(ListDataEvent e) {
        update(e);
    }

    protected void update(ListDataEvent e) {
    }
}
