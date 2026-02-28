

package com.eviware.soapui.model.support;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.UISupport;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public class ShowModelItemAction extends AbstractAction {
    private final ModelItem modelItem;

    public ShowModelItemAction(String title, ModelItem modelItem) {
        super(title);
        this.modelItem = modelItem;
    }

    public void actionPerformed(ActionEvent e) {
        UISupport.selectAndShow(modelItem);
    }
}
