

package com.eviware.soapui.impl.rest.panels.request.inspectors.schema;

import com.eviware.soapui.impl.rest.RestRequest;
import com.eviware.soapui.impl.rest.RestRequestInterface;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.editor.Editor;
import com.eviware.soapui.support.editor.EditorInspector;
import com.eviware.soapui.support.editor.registry.ResponseInspectorFactory;

/**
 * @author Dain.Nilsson
 */
public class InferredSchemaInspectorFactory implements ResponseInspectorFactory {
    public static final String INSPECTOR_ID = "InferredSchema";

    public String getInspectorId() {
        return INSPECTOR_ID;
    }

    public EditorInspector<?> createResponseInspector(Editor<?> editor, ModelItem modelItem) {
        if (modelItem instanceof RestRequestInterface) {
            return new InferredSchemaInspector((RestRequest) modelItem);
        }

        return null;
    }

}
