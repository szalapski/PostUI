

package com.eviware.soapui.support.editor.registry;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.editor.Editor;
import com.eviware.soapui.support.editor.EditorView;

/**
 * Interface for response editor views
 *
 * @author ole.matzura
 */

public interface ResponseEditorViewFactory extends EditorViewFactory {
    EditorView<?> createResponseEditorView(Editor<?> editor, ModelItem modelItem);
}
