/**
 * MySwing: Advanced Swing Utilites
 * Copyright (C) 2005  Santhosh Kumar T
 * <p/>
 */

package skt.swing.tree.check;

import javax.swing.tree.TreePath;

/**
 * @author Santhosh Kumar T
 * @email santhosh@in.fiorano.com
 */
public interface TreePathSelectable {
    public boolean isSelectable(TreePath path);
}