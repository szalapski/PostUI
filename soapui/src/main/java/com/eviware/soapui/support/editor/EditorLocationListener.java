

package com.eviware.soapui.support.editor;

/**
 * Listener to location-changes
 *
 * @author ole.matzura
 */

public interface EditorLocationListener<T extends EditorDocument> {
    public void locationChanged(EditorLocation<T> location);
}
