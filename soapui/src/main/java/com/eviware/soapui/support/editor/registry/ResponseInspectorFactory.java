

package com.eviware.soapui.support.editor.registry;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.editor.Editor;
import com.eviware.soapui.support.editor.EditorInspector;

/**
 * Interface fore response inspectors
 *
 * @author ole.matzura
 */

public interface ResponseInspectorFactory extends InspectorFactory {
    EditorInspector<?> createResponseInspector(Editor<?> editor, ModelItem modelItem);
}
