

package com.eviware.soapui.support.editor.inspectors.script;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.mock.MockResponse;
import com.eviware.soapui.support.editor.Editor;
import com.eviware.soapui.support.editor.EditorInspector;
import com.eviware.soapui.support.editor.registry.ResponseInspectorFactory;

public class ScriptInspectorFactory implements ResponseInspectorFactory {
    public static final String INSPECTOR_ID = "Script";

    public String getInspectorId() {
        return INSPECTOR_ID;
    }

    public EditorInspector<?> createResponseInspector(Editor<?> editor, ModelItem modelItem) {
        if (modelItem instanceof MockResponse) {
            return new MockResponseScriptInspector((MockResponse) modelItem);
        }

        return null;
    }
}
