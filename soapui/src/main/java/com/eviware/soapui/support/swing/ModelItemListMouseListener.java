

package com.eviware.soapui.support.swing;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.action.swing.ActionList;
import com.eviware.soapui.support.action.swing.ActionListBuilder;

import javax.swing.JList;

/**
 * ListMouseListener for ModelItems
 *
 * @author ole.matzura
 */

public class ModelItemListMouseListener extends AbstractListMouseListener {
    public ModelItemListMouseListener() {
        this(true);
    }

    public ModelItemListMouseListener(boolean enablePopup) {
        super(enablePopup);
    }

    @Override
    protected ActionList getActionsForRow(JList list, int row) {
        ModelItem item = (ModelItem) list.getModel().getElementAt(row);
        try {
            return item == null ? null : ActionListBuilder.buildActions(item);
        } catch (Exception e) {
            return null;
        }
    }
}
