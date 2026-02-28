

package com.eviware.soapui.support.components;

public interface Undoable {
    public void undo();

    public void redo();

    public boolean canUndo();

    public boolean canRedo();
}
