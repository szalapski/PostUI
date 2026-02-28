

package com.eviware.soapui.impl.wsdl.panels.assertions;

import javax.swing.table.DefaultTableModel;
import java.util.SortedSet;

public class AssertionsListTableModel extends DefaultTableModel {
    SortedSet<AssertionListEntry> listEntriesSet;

    public AssertionsListTableModel() {
    }

    public void setListEntriesSet(SortedSet<AssertionListEntry> listEntriesSet) {
        this.listEntriesSet = listEntriesSet;
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public int getRowCount() {
        if (listEntriesSet != null) {
            return listEntriesSet.size();
        } else {
            return 1;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (listEntriesSet != null) {
            return listEntriesSet.toArray()[rowIndex];
        } else {
            return null;
        }
    }
}
