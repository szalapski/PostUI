

package com.eviware.soapui.support.editor;

import com.eviware.soapui.support.PropertyChangeNotifier;

import javax.swing.JComponent;

/**
 * Views available for the XmlDocument of a XmlEditor
 *
 * @author ole.matzura
 */

public interface EditorView<T extends EditorDocument> extends PropertyChangeNotifier, EditorLocationListener<T> {
    public final static String TITLE_PROPERTY = EditorView.class.getName() + "@title";

    public Editor<T> getEditor();

    public String getTitle();

    public JComponent getComponent();

    public boolean deactivate();

    public boolean activate(EditorLocation<T> location);

    public EditorLocation<T> getEditorLocation();

    public void setLocation(EditorLocation<T> location);

    public void setDocument(T document);

    public T getDocument();

    public void addLocationListener(EditorLocationListener<T> listener);

    public void removeLocationListener(EditorLocationListener<T> listener);

    public void release();

    public void setEditable(boolean enabled);

    public String getViewId();

    public void requestFocus();

    /**
     * Returns the score of how well a given content type is supported by this editor view
     * @param contentType http payload's content type
     * @return a non-negative integer: greater values mean better support,
     * 0 means the given content type is not supported by this view
     */
    int getSupportScoreForContentType(String contentType);
}
