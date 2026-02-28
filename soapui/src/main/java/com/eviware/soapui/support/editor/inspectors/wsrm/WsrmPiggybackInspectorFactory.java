

package com.eviware.soapui.support.editor.inspectors.wsrm;

import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.editor.Editor;
import com.eviware.soapui.support.editor.EditorInspector;
import com.eviware.soapui.support.editor.registry.RequestInspectorFactory;

public class WsrmPiggybackInspectorFactory implements RequestInspectorFactory {

    public static final String INSPECTOR_ID = "WS-RM_Piggyback";

    public String getInspectorId() {
        return INSPECTOR_ID;
    }

    public EditorInspector<?> createRequestInspector(Editor<?> editor, ModelItem modelItem) {
        if (modelItem instanceof WsdlRequest) {
            return new WsdlRequestWsrmPiggybackInspector(((WsdlRequest) modelItem));
        }

        return null;
    }
}
