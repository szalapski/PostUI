

package com.eviware.soapui.support.swing;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.action.swing.ActionList;
import com.eviware.soapui.support.action.swing.ActionListBuilder;

import javax.swing.JTable;

/**
 * ListMouseListener for ModelItems
 *
 * @author ole.matzura
 */

public abstract class AbstractModelItemTableMouseListener extends AbstractTableMouseListener {
    public AbstractModelItemTableMouseListener() {
        this(true);
    }

    public AbstractModelItemTableMouseListener(boolean enablePopup) {
        super(enablePopup);
    }

    @Override
    protected ActionList getActionsForRow(JTable table, int row) {
        ModelItem item = (ModelItem) getModelItemAt(row);
        try {
            return item == null ? null : ActionListBuilder.buildActions(item);
        } catch (Exception e) {
            return null;
        }
    }

    abstract protected ModelItem getModelItemAt(int row);
}
