

package com.eviware.soapui.support.editor.registry;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.editor.Editor;
import com.eviware.soapui.support.editor.EditorInspector;

/**
 * Interface fore request inspectors
 *
 * @author ole.matzura
 */

public interface RequestInspectorFactory extends InspectorFactory {
    EditorInspector<?> createRequestInspector(Editor<?> editor, ModelItem modelItem);
}
