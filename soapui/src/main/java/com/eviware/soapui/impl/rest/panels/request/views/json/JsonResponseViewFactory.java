

package com.eviware.soapui.impl.rest.panels.request.views.json;

import com.eviware.soapui.impl.support.http.HttpRequestInterface;
import com.eviware.soapui.impl.support.panels.AbstractHttpXmlRequestDesktopPanel.HttpResponseMessageEditor;
import com.eviware.soapui.impl.wsdl.support.MessageExchangeModelItem;
import com.eviware.soapui.impl.wsdl.support.MessageExchangeResponseMessageEditor;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.editor.Editor;
import com.eviware.soapui.support.editor.EditorView;
import com.eviware.soapui.support.editor.registry.ResponseEditorViewFactory;

public class JsonResponseViewFactory implements ResponseEditorViewFactory {
    public final static String VIEW_ID = "JSON Response";

    @SuppressWarnings("unchecked")
    public EditorView<?> createResponseEditorView(Editor<?> editor, ModelItem modelItem) {
        if (editor instanceof HttpResponseMessageEditor && modelItem instanceof HttpRequestInterface<?>) {
            return new JsonResponseView((HttpResponseMessageEditor) editor, (HttpRequestInterface<?>) modelItem);
        }
        if (modelItem instanceof MessageExchangeModelItem) {
            return new JsonResponseMessageExchangeView((MessageExchangeResponseMessageEditor) editor,
                    (MessageExchangeModelItem) modelItem);
        }
        return null;
    }

    public String getViewId() {
        return VIEW_ID;
    }
}
