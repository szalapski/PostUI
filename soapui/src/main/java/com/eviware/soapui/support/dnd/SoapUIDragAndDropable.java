

package com.eviware.soapui.support.dnd;

import javax.swing.JComponent;
import java.awt.Component;
import java.awt.Rectangle;

public interface SoapUIDragAndDropable<T> {
    public JComponent getComponent();

    public void setDragInfo(String dropInfo);

    public void selectModelItem(T modelItem);

    public T getModelItemForLocation(int x, int y);

    public Rectangle getModelItemBounds(T modelItem);

    public Component getRenderer(T modelItem);

    public void toggleExpansion(T modelItem);
}
