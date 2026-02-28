

package com.eviware.soapui.support.editor.inspectors.attachments;

import com.eviware.soapui.impl.wsdl.AttachmentContainer;
import com.eviware.soapui.support.editor.EditorView;
import com.eviware.soapui.support.editor.inspectors.AbstractXmlInspector;
import com.eviware.soapui.support.editor.views.xml.raw.RawXmlEditorFactory;
import com.eviware.soapui.support.editor.xml.XmlDocument;

import javax.swing.JComponent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AttachmentsInspector extends AbstractXmlInspector implements PropertyChangeListener {
    private AttachmentContainer container;
    private AttachmentsPanel attachmentsPanel;

    public AttachmentsInspector(AttachmentContainer container) {
        super("Attachments (" + container.getAttachmentCount() + ")", "Files attached to this message", true,
                AttachmentsInspectorFactory.INSPECTOR_ID);
        this.container = container;

        container.addAttachmentsChangeListener(this);
    }

    public JComponent getComponent() {
        if (attachmentsPanel == null) {
            attachmentsPanel = new AttachmentsPanel(container);
        }

        return attachmentsPanel;
    }

    @Override
    public void release() {
        super.release();
        attachmentsPanel.release();
        container.removeAttachmentsChangeListener(this);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        setTitle("Attachments (" + container.getAttachmentCount() + ")");
    }

    @Override
    public boolean isEnabledFor(EditorView<XmlDocument> view) {
        return !view.getViewId().equals(RawXmlEditorFactory.VIEW_ID);
    }
}
