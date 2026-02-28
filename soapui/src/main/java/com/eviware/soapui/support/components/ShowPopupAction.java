

package com.eviware.soapui.support.components;

import com.eviware.soapui.support.UISupport;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import java.awt.event.ActionEvent;

public class ShowPopupAction extends AbstractAction {
    private final JComponent popupContainer;
    private final JComponent container;

    public ShowPopupAction(JComponent popupContainer, JComponent container) {
        this.popupContainer = popupContainer;
        this.container = container;

        putValue(SMALL_ICON, UISupport.createImageIcon("/get_data_button.gif"));
    }

    public void actionPerformed(ActionEvent e) {
        popupContainer.getComponentPopupMenu().show(container, container.getWidth() / 2, container.getHeight() / 2);
    }
}
