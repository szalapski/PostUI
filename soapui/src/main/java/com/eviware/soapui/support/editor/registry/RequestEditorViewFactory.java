

package com.eviware.soapui.support.editor.registry;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.editor.Editor;
import com.eviware.soapui.support.editor.EditorView;

/**
 * Interface fore request editor views
 *
 * @author ole.matzura
 */

public interface RequestEditorViewFactory extends EditorViewFactory {
    EditorView<?> createRequestEditorView(Editor<?> editor, ModelItem modelItem);
}
