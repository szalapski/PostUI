

package com.eviware.soapui.support.editor.inspectors.jms.property;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.types.StringToStringMap;
import org.apache.commons.lang.NotImplementedException;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public interface JMSPropertyInspectorModel {
    public StringToStringMap getJMSProperties();

    public void addPropertyChangeListener(PropertyChangeListener listener);

    public void setJMSProperties(StringToStringMap jmsProperties);

    public void removePropertyChangeListener(PropertyChangeListener listener);

    public boolean isReadOnly();

    public void release();

    public void setInspector(JMSPropertyInspector inspector);

    public static abstract class AbstractJMSPropertyModel<T extends ModelItem> implements JMSPropertyInspectorModel,
            PropertyChangeListener {
        private boolean readOnly;
        private PropertyChangeSupport propertyChangeSupport;
        private final T modelItem;
        private final String propertyName;

        protected AbstractJMSPropertyModel(boolean readOnly, T modelItem, String propertyName) {
            this.readOnly = readOnly;
            this.modelItem = modelItem;
            this.propertyName = propertyName;
            propertyChangeSupport = new PropertyChangeSupport(this);
            modelItem.addPropertyChangeListener(propertyName, this);
        }

        public void addPropertyChangeListener(PropertyChangeListener listener) {
            propertyChangeSupport.addPropertyChangeListener(listener);
        }

        public boolean isReadOnly() {
            return readOnly;
        }

        public void removePropertyChangeListener(PropertyChangeListener listener) {
            propertyChangeSupport.removePropertyChangeListener(listener);
        }

        public void propertyChange(PropertyChangeEvent evt) {
            propertyChangeSupport.firePropertyChange(evt);
        }

        public void release() {
            modelItem.removePropertyChangeListener(propertyName, this);
        }

        public T getModelItem() {
            return modelItem;
        }

        public void setJMSProperties(StringToStringMap jmsPorperties) {
            if (!readOnly) {
                throw new NotImplementedException();
            }
        }
    }
}
