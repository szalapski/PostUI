/**
 * MySwing: Advanced Swing Utilites
 * Copyright (C) 2005  Santhosh Kumar T
 */

package skt.swing.tree;

import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/**
 * @author Santhosh Kumar T
 * @email santhosh@in.fiorano.com
 */
public class ChildrenEnumeration implements Enumeration {
    private TreePath path;
    private TreeModel model;
    private int position = 0;
    private int childCount;

    public ChildrenEnumeration(TreePath path, TreeModel model) {
        this.path = path;
        this.model = model;
        childCount = model.getChildCount(path.getLastPathComponent());
    }

    public boolean hasMoreElements() {
        return position < childCount;
    }

    public Object nextElement() {
        if (!hasMoreElements()) {
            throw new NoSuchElementException();
        }
        return path.pathByAddingChild(model.getChild(path.getLastPathComponent(), position++));
    }
}
