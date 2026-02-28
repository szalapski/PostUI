

package com.eviware.soapui.support.editor.xml.support;

import com.eviware.soapui.support.editor.xml.XmlDocument;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Abstract base-class for XmlDocument implementations
 *
 * @author ole.matzura
 */

public abstract class AbstractXmlDocument implements XmlDocument {
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
    }

    protected void fireContentChanged() {
        propertyChangeSupport.firePropertyChange(DOCUMENT_PROPERTY, null, this);
    }

    public void release() {
    }

    public SchemaTypeSystem getTypeSystem() {
        return XmlBeans.getBuiltinTypeSystem();
    }

    @Override
    public String getContentType() {
        return null;
    }
}
