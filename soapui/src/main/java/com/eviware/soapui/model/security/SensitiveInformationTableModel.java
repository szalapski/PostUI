

package com.eviware.soapui.model.security;

import com.eviware.soapui.impl.wsdl.MutableTestPropertyHolder;
import com.eviware.soapui.model.testsuite.TestProperty;
import com.eviware.soapui.security.SensitiveInformationPropertyHolder.SensitiveTokenProperty;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class SensitiveInformationTableModel extends DefaultTableModel {

    private String[] columnNames = {"Token", "Description"};
    private MutableTestPropertyHolder holder;

    public MutableTestPropertyHolder getHolder() {
        return holder;
    }

    public SensitiveInformationTableModel(MutableTestPropertyHolder holder) {
        this.holder = holder;
    }

    public SensitiveInformationTableModel(MutableTestPropertyHolder holder, String tokenHeader) {
        this(holder);
        columnNames[0] = tokenHeader;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    @Override
    public Object getValueAt(int row, int column) {
        TestProperty param = holder.getPropertyList().get(row);
        switch (column) {
            case 0:
                return param.getName();
            case 1:
                return param.getValue();

        }
        return super.getValueAt(row, column);
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        if (holder.getPropertyList().isEmpty()) {
            return;
        }
        SensitiveTokenProperty param = (SensitiveTokenProperty) holder.getPropertyList().get(row);
        switch (column) {
            case 0:
                param.setName((String) aValue);
                break;
            case 1:
                param.setValue((String) aValue);
                break;

        }
    }

    public void addToken(String token, String description) {
        holder.setPropertyValue(token, description);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return holder == null ? 0 : holder.getPropertyList() == null ? 0 : holder.getPropertyList().size();
    }

    public void removeRows(int[] selectedRows) {
        ArrayList<String> toRemove = new ArrayList<>();

        for (int index : selectedRows) {
            String name = (String) getValueAt(index, 0);
            toRemove.add(name);
        }
        for (String name : toRemove) {
            holder.removeProperty(name);
        }
        fireTableDataChanged();
    }

}
