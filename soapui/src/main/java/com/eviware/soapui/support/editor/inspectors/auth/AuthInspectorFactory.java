

package com.eviware.soapui.support.editor.inspectors.auth;

import com.eviware.soapui.impl.support.AbstractHttpRequest;
import com.eviware.soapui.impl.support.AbstractHttpRequestInterface;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.editor.Editor;
import com.eviware.soapui.support.editor.EditorInspector;
import com.eviware.soapui.support.editor.registry.RequestInspectorFactory;

public class AuthInspectorFactory implements RequestInspectorFactory {
    public static final String INSPECTOR_ID = "Auth";

    public String getInspectorId() {
        return INSPECTOR_ID;
    }

    public EditorInspector<?> createRequestInspector(Editor<?> editor, ModelItem modelItem) {
        if (modelItem instanceof AbstractHttpRequestInterface<?>) {
            return new ProfileSelectionForm((AbstractHttpRequest) modelItem);
        }
        return null;
    }
}
