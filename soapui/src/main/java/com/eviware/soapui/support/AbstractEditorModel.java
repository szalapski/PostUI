

package com.eviware.soapui.support;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractEditorModel implements EditorModel {
    private Set<EditorModelListener> listeners = new HashSet<>();

    public void addEditorModelListener(EditorModelListener editorModelListener) {
        listeners.add(editorModelListener);
    }

    public void removeEditorModelListener(EditorModelListener editorModelListener) {
        listeners.remove(editorModelListener);
    }

    public void fireEditorTextChanged(String oldText, String newText) {
        for (EditorModelListener listener : listeners) {
            listener.editorTextChanged(oldText, newText);
        }
    }

    public void release() {
        listeners.clear();
    }
}
