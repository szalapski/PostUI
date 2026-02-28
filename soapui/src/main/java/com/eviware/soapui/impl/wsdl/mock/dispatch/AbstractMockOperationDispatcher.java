

package com.eviware.soapui.impl.wsdl.mock.dispatch;

import com.eviware.soapui.model.mock.MockOperation;
import com.eviware.soapui.support.PropertyChangeNotifier;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class AbstractMockOperationDispatcher implements PropertyChangeNotifier, MockOperationDispatcher {
    private MockOperation mockOperation;
    private PropertyChangeSupport propertyChangeSupport;

    protected AbstractMockOperationDispatcher(MockOperation mockOperation) {
        this.mockOperation = mockOperation;
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public JComponent getEditorComponent() {
        return new JPanel();
    }

    @Override
    public void releaseEditorComponent() {
    }

    @Override
    public void release() {
        // TODO : the following line causes NullPointerException when getSettings
        // TODO : will removing it cause a memory leak?
        //mockOperation = null;
    }

    public MockOperation getMockOperation() {
        return mockOperation;
    }

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

    protected PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }
}
