

package com.eviware.soapui.impl.support.http;

import com.eviware.soapui.impl.rest.RestRequestInterface;
import com.eviware.soapui.impl.rest.panels.request.views.content.RestRequestContentView;
import com.eviware.soapui.impl.rest.panels.request.views.content.RestTestRequestContentView;
import com.eviware.soapui.impl.support.panels.AbstractHttpXmlRequestDesktopPanel;
import com.eviware.soapui.impl.support.panels.AbstractHttpXmlRequestDesktopPanel.HttpRequestMessageEditor;
import com.eviware.soapui.impl.wsdl.teststeps.RestTestRequestInterface;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.editor.Editor;
import com.eviware.soapui.support.editor.EditorView;
import com.eviware.soapui.support.editor.registry.RequestEditorViewFactory;

public class HttpRequestContentViewFactory implements RequestEditorViewFactory {
    public final static String VIEW_ID = "HTTP Content";

    public EditorView<?> createRequestEditorView(Editor<?> editor, ModelItem modelItem) {
        if (editor instanceof AbstractHttpXmlRequestDesktopPanel.HttpRequestMessageEditor && modelItem instanceof HttpRequestInterface<?>) {
            if (modelItem instanceof RestTestRequestInterface) {
                return new RestTestRequestContentView((HttpRequestMessageEditor) editor, (RestRequestInterface) modelItem);
            } else if (modelItem instanceof RestRequestInterface) {
                return new RestRequestContentView((HttpRequestMessageEditor) editor, (RestRequestInterface) modelItem);
            } else {
                return new HttpRequestContentView((HttpRequestMessageEditor) editor, (HttpRequestInterface<?>) modelItem);
            }
        }

        return null;
    }

    public String getViewId() {
        return VIEW_ID;
    }
}
