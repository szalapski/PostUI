

package com.eviware.soapui.impl.rest.panels.request.views.html;

import com.eviware.soapui.impl.support.http.HttpRequestInterface;
import com.eviware.soapui.impl.support.panels.AbstractHttpXmlRequestDesktopPanel.HttpResponseMessageEditor;
import com.eviware.soapui.impl.wsdl.support.MessageExchangeModelItem;
import com.eviware.soapui.impl.wsdl.support.MessageExchangeResponseMessageEditor;
import com.eviware.soapui.impl.wsdl.teststeps.GraphQLTestRequest;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.editor.Editor;
import com.eviware.soapui.support.editor.EditorView;
import com.eviware.soapui.support.editor.registry.ResponseEditorViewFactory;

public class HttpHtmlResponseViewFactory implements ResponseEditorViewFactory {
    public final static String VIEW_ID = "HTML Response";

    @SuppressWarnings("unchecked")
    public EditorView<?> createResponseEditorView(Editor<?> editor, ModelItem modelItem) {
        if (modelItem instanceof GraphQLTestRequest) {
            return null;
        }
        if (editor instanceof HttpResponseMessageEditor && modelItem instanceof HttpRequestInterface<?>) {
            return new HttpHtmlResponseView((HttpResponseMessageEditor) editor, (HttpRequestInterface<?>) modelItem);
        }
        if (modelItem instanceof MessageExchangeModelItem) {
            return new HttpHtmlMessageExchangeResponseView((MessageExchangeResponseMessageEditor) editor,
                    (MessageExchangeModelItem) modelItem);
        }
        return null;
    }

    public String getViewId() {
        return VIEW_ID;
    }
}
