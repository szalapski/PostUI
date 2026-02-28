/**
 * MySwing: Advanced Swing Utilites
 * Copyright (C) 2005  Santhosh Kumar T
 */

package skt.swing.tree;

import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Stack;

/**
 * @author Santhosh Kumar T
 * @email santhosh@in.fiorano.com
 */
public class PreorderEnumeration implements Enumeration {
    private TreeModel model;
    protected Stack stack = new Stack();

    public PreorderEnumeration(TreePath path, TreeModel model) {
        this(Collections.enumeration(Collections.singletonList(path)), model);
    }

    public PreorderEnumeration(Enumeration enumer, TreeModel model) {
        this.model = model;
        stack.push(enumer);
    }

    public boolean hasMoreElements() {
        return (!stack.empty() &&
                ((Enumeration) stack.peek()).hasMoreElements());
    }

    public Object nextElement() {
        Enumeration enumer = (Enumeration) stack.peek();
        TreePath path = (TreePath) enumer.nextElement();

        if (!enumer.hasMoreElements()) {
            stack.pop();
        }

        if (model.getChildCount(path.getLastPathComponent()) > 0) {
            stack.push(new ChildrenEnumeration(path, model));
        }
        return path;
    }
}
