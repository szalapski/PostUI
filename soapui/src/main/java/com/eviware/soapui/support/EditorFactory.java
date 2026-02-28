

package com.eviware.soapui.support;

import com.eviware.soapui.impl.wsdl.panels.teststeps.support.GroovyEditorModel;

import javax.swing.JComponent;

public interface EditorFactory {
    public JComponent buildXPathEditor(EditorModel editorModel);

    public JComponent buildXmlEditor(EditorModel editorModel);

    public JComponent buildGroovyEditor(GroovyEditorModel editorModel);
}
