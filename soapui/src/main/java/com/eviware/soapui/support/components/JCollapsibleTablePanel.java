

package com.eviware.soapui.support.components;

import com.eviware.soapui.support.UISupport;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class JCollapsibleTablePanel extends JCollapsiblePanel {

    private JTable table;
    private String title;

    public JCollapsibleTablePanel(JTable table, String title) {
        super(new JPanel(), title);
        setTable(table);
        setMinusIcon(UISupport.createImageIcon("/minus.gif"));
        setPlusIcon(UISupport.createImageIcon("/plus.gif"));
        this.title = title;
    }

    private void setTable(JTable table) {
        this.table = table;
        this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JPanel content = new JPanel(new BorderLayout());
        content.add(table, BorderLayout.CENTER);
        setContentPanel(content);
    }

    public JTable getTable() {
        return table;
    }

    public String getTitle() {
        return title;
    }
}
