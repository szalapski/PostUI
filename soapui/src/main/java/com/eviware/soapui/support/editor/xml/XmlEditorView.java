

package com.eviware.soapui.support.editor.xml;

import com.eviware.soapui.support.editor.EditorView;

/**
 * Views available for the XmlDocument of a XmlEditor
 *
 * @author ole.matzura
 */

public interface XmlEditorView<T extends XmlDocument> extends EditorView<T> {
    public boolean saveDocument(boolean validate);
}
