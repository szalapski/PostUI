/**
 * MySwing: Advanced Swing Utilites
 * Copyright (C) 2005  Santhosh Kumar T
 */

package skt.swing.tree.check;

import javax.swing.*;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import java.awt.*;

/**
 * @author Santhosh Kumar T
 * @email santhosh@in.fiorano.com
 */

public class CheckTreeCellRenderer extends JPanel implements TreeCellRenderer {
    private CheckTreeSelectionModel selectionModel;
    private TreePathSelectable selectable;
    private TreeCellRenderer delegate;
    private TristateCheckBox checkBox = new TristateCheckBox();

    public CheckTreeCellRenderer(TreeCellRenderer delegate, CheckTreeSelectionModel selectionModel, TreePathSelectable selectable) {
        this.delegate = delegate;
        this.selectionModel = selectionModel;
        this.selectable = selectable;
        setLayout(new BorderLayout());
        setOpaque(false);
        checkBox.setOpaque(false);
    }


    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component renderer = delegate.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        TreePath path = tree.getPathForRow(row);
        if (path != null) {
            if (selectionModel.isPathSelected(path, selectionModel.isDigged())) {
                checkBox.setState(Boolean.TRUE);
            } else {
                checkBox.setState(selectionModel.isDigged() && selectionModel.isPartiallySelected(path) ? null : Boolean.FALSE);
            }
        }
        removeAll();
        checkBox.setVisible(path == null || selectable == null || selectable.isSelectable(path));
        add(checkBox, BorderLayout.WEST);
        add(renderer, BorderLayout.CENTER);
        return this;
    }
}
