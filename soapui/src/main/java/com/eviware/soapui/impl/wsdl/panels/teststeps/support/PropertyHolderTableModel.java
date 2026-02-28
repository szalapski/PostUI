

package com.eviware.soapui.impl.wsdl.panels.teststeps.support;

import com.eviware.soapui.model.testsuite.TestProperty;

import javax.swing.table.TableModel;

public interface PropertyHolderTableModel extends TableModel {
    public abstract void fireTableDataChanged();

    public abstract TestProperty getPropertyAtRow(int rowIndex);

    public abstract void fireTableRowsDeleted(int row, int row2);

    public abstract void fireTableRowsInserted(int row, int row2);

    public void moveProperty(String propName, int oldRow, int newRow);
}
