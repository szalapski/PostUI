

package com.eviware.soapui.support.editor.xml;

import com.eviware.soapui.support.editor.Editor;
import com.eviware.soapui.support.editor.EditorInspector;
import com.eviware.soapui.support.editor.EditorLocationListener;
import com.eviware.soapui.support.editor.EditorView;

/**
 * Inspectors available for the XmlDocument of a XmlEditor
 *
 * @author ole.matzura
 */

public interface XmlInspector extends EditorLocationListener<XmlDocument>, EditorInspector<XmlDocument> {
    public void init(Editor<XmlDocument> editor);

    public Editor<XmlDocument> getEditor();

    public boolean isContentHandler();

    public boolean isEnabledFor(EditorView<XmlDocument> view);
}
