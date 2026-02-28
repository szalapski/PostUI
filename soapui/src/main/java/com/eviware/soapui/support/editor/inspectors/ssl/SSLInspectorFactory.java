

package com.eviware.soapui.support.editor.inspectors.ssl;

import com.eviware.soapui.impl.support.AbstractHttpRequest;
import com.eviware.soapui.impl.support.AbstractHttpRequestInterface;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.editor.Editor;
import com.eviware.soapui.support.editor.EditorInspector;
import com.eviware.soapui.support.editor.registry.ResponseInspectorFactory;

public class SSLInspectorFactory implements ResponseInspectorFactory {
    public static final String INSPECTOR_ID = "SSL Info";

    public String getInspectorId() {
        return INSPECTOR_ID;
    }

    public EditorInspector<?> createResponseInspector(Editor<?> editor, ModelItem modelItem) {
        if (modelItem instanceof AbstractHttpRequestInterface<?>) {
            return new ResponseSSLInspector((AbstractHttpRequest<?>) modelItem);
        }

        return null;
    }
}
