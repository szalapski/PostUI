

package com.eviware.soapui.support.editor;

import com.eviware.soapui.support.components.Inspector;

/**
 * Inspectors available for the XmlDocument of a XmlEditor
 *
 * @author ole.matzura
 */

public interface EditorInspector<T extends EditorDocument> extends EditorLocationListener<T>, Inspector {
    public void init(Editor<T> editor);

    public Editor<T> getEditor();

    public boolean isContentHandler();

    public boolean isEnabledFor(EditorView<T> view);
}
