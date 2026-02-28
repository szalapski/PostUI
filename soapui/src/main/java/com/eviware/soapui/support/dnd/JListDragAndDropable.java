

package com.eviware.soapui.support.dnd;

import com.eviware.soapui.model.ModelItem;

import javax.swing.JComponent;
import javax.swing.JList;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class JListDragAndDropable<T extends JList> implements SoapUIDragAndDropable<ModelItem> {
    private T list;
    private ModelItem parent;

    public JListDragAndDropable(T list, ModelItem parent) {
        this.list = list;
        this.parent = parent;
    }

    public T getList() {
        return list;
    }

    public abstract ModelItem getModelItemAtRow(int row);

    public JComponent getComponent() {
        return list;
    }

    public Rectangle getModelItemBounds(ModelItem modelItem) {
        if (modelItem == parent) {
            return list.getBounds();
        }

        int ix = getModelItemRow(modelItem);
        return list.getCellBounds(ix, ix);
    }

    public abstract int getModelItemRow(ModelItem modelItem);

    public void selectModelItem(ModelItem modelItem) {
        list.setSelectedIndex(getModelItemRow(modelItem));
    }

    public void setDragInfo(String dropInfo) {
        list.setToolTipText(dropInfo);
    }

    public ModelItem getModelItemForLocation(int x, int y) {
        int index = list.locationToIndex(new Point(x, y));
        return index == -1 ? parent : getModelItemAtRow(index);
    }

    public void toggleExpansion(ModelItem last) {
    }
}
