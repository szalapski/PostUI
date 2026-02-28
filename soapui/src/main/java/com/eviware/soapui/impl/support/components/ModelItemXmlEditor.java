

package com.eviware.soapui.impl.support.components;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.editor.views.xml.source.XmlSourceEditorView;
import com.eviware.soapui.support.editor.views.xml.source.XmlSourceEditorViewFactory;
import com.eviware.soapui.support.editor.xml.XmlDocument;
import com.eviware.soapui.support.editor.xml.XmlEditor;

/**
 * Base XmlEditor class for editing SOAP Messages
 *
 * @author ole.matzura
 */

public abstract class ModelItemXmlEditor<T extends ModelItem, T2 extends XmlDocument> extends XmlEditor<T2> {
    private final T modelItem;

    public ModelItemXmlEditor(T2 xmlDocument, T modelItem) {
        super(xmlDocument);
        this.modelItem = modelItem;
    }

    public T getModelItem() {
        return modelItem;
    }

    public final XmlSourceEditorView getSourceEditor() {
        return (XmlSourceEditorView) getView(XmlSourceEditorViewFactory.VIEW_ID);
    }
}
