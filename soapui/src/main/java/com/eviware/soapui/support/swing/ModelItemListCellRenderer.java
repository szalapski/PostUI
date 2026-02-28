

package com.eviware.soapui.support.swing;

import com.eviware.soapui.model.ModelItem;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import java.awt.Component;

@SuppressWarnings("serial")
public class ModelItemListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {
        Component result = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof ModelItem) {
            ModelItem item = (ModelItem) value;
            setIcon(item.getIcon());
            setText(item.getName());
        }

        return result;
    }

}
