

package com.eviware.soapui.support.editor.inspectors.wsa;

import com.eviware.soapui.impl.support.AbstractHttpRequest;
import com.eviware.soapui.impl.wsdl.support.wsa.WsaContainer;
import com.eviware.soapui.support.components.SimpleBindingForm;
import com.eviware.soapui.support.editor.EditorView;
import com.eviware.soapui.support.editor.inspectors.AbstractXmlInspector;
import com.eviware.soapui.support.editor.views.xml.raw.RawXmlEditorFactory;
import com.eviware.soapui.support.editor.xml.XmlDocument;
import com.jgoodies.binding.PresentationModel;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public abstract class AbstractWsaInspector extends AbstractXmlInspector {
    private JPanel mainPanel;
    private SimpleBindingForm form;
    private final WsaContainer wsaContainer;

    protected AbstractWsaInspector(WsaContainer wsaContainer) {
        super("WS-A", "WS-Addressing related settings", true, WsaInspectorFactory.INSPECTOR_ID);
        this.wsaContainer = wsaContainer;
    }

    public JComponent getComponent() {
        if (mainPanel == null) {
            mainPanel = new JPanel(new BorderLayout());
            form = new SimpleBindingForm(new PresentationModel<AbstractHttpRequest<?>>(wsaContainer.getWsaConfig()));
            buildContent(form);
            mainPanel.add(new JScrollPane(form.getPanel()), BorderLayout.CENTER);
        }
        return mainPanel;
    }

    @Override
    public void release() {
        super.release();

        if (form != null) {
            form.getPresentationModel().release();
        }
    }

    public void buildContent(SimpleBindingForm form) {
    }

    ;

    @Override
    public boolean isEnabledFor(EditorView<XmlDocument> view) {
        return !view.getViewId().equals(RawXmlEditorFactory.VIEW_ID);
    }

}
