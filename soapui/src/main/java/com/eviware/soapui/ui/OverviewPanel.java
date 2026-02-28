

package com.eviware.soapui.ui;

import com.eviware.soapui.model.ModelItem;

import javax.swing.JComponent;

public interface OverviewPanel {
    public JComponent getComponent();

    public ModelItem getModelItem();

    public void setModelItem(ModelItem modelItem);
}
