

package com.eviware.soapui.impl.wsdl.panels.assertions;

import javax.swing.table.DefaultTableModel;
import java.util.Set;

public class AssertionCategoriesTableModel extends DefaultTableModel {
    Set<String> listEntriesSet;

    public AssertionCategoriesTableModel() {
    }

    public void setLisetEntriesSet(Set<String> keySet) {
        listEntriesSet = keySet;
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
    public Object getValueAt(int row, int column) {
        if (listEntriesSet != null) {
            return listEntriesSet.toArray()[row];
        } else {
            return null;
        }
    }

}
