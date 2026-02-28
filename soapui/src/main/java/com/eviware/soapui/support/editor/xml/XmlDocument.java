

package com.eviware.soapui.support.editor.xml;

import com.eviware.soapui.support.editor.EditorDocument;
import org.apache.xmlbeans.SchemaTypeSystem;

/**
 * Document class used by XmlEditors
 *
 * @author ole.matzura
 */

public interface XmlDocument extends EditorDocument {
    public SchemaTypeSystem getTypeSystem();
}
