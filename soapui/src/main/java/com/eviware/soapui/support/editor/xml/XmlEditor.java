

package com.eviware.soapui.support.editor.xml;

import com.eviware.soapui.support.editor.Editor;
import com.eviware.soapui.support.editor.views.xml.source.XmlSourceEditorView;

/**
 * Editor-framework for Xml Documents
 *
 * @author ole.matzura
 */

@SuppressWarnings("serial")
public abstract class XmlEditor<T extends XmlDocument> extends Editor<T> {
    public XmlEditor(T xmlDocument) {
        super(xmlDocument);
    }

    public boolean saveDocument(boolean validate) {
        XmlEditorView<?> currentView = (XmlEditorView<?>) getCurrentView();
        return currentView == null ? true : currentView.saveDocument(validate);
    }

    @SuppressWarnings("unchecked")
    public abstract XmlSourceEditorView getSourceEditor();


}
