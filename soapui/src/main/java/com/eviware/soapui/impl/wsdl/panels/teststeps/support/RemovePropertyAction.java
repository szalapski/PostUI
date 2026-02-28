

package com.eviware.soapui.impl.wsdl.panels.teststeps.support;

import com.eviware.soapui.impl.wsdl.MutableTestPropertyHolder;
import com.eviware.soapui.support.UISupport;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import java.awt.event.ActionEvent;

/**
 * @author Prakash
 */
public class RemovePropertyAction extends AbstractAction {
    private final JTable propertyTable;
    private final MutableTestPropertyHolder propertyHolder;
    public static final String DELETE_PARAM_ACTON_NAME = "Delete Param";

    public RemovePropertyAction(JTable propertyTable, MutableTestPropertyHolder propertyHolder, String description) {
        super(DELETE_PARAM_ACTON_NAME);
        this.propertyTable = propertyTable;
        this.propertyHolder = propertyHolder;
        putValue(Action.SMALL_ICON, UISupport.createImageIcon("/delete.png"));
        putValue(Action.SHORT_DESCRIPTION, description);
        setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        int row = propertyTable.getSelectedRow();
        if (row == -1) {
            return;
        }

        UISupport.stopCellEditing(propertyTable);

        String propertyName = propertyTable.getValueAt(row, 0).toString();
        if (UISupport.confirm("Remove parameter [" + propertyName + "]?", "Remove Parameter")) {
            propertyTable.clearSelection();
            propertyHolder.removeProperty(propertyName);
        }
    }
}
