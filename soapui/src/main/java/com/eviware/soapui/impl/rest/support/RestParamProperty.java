

package com.eviware.soapui.impl.rest.support;

import com.eviware.soapui.model.testsuite.RenameableTestProperty;

import java.beans.PropertyChangeListener;

public interface RestParamProperty extends RenameableTestProperty, RestParameter {
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);

    public abstract void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);

    public abstract void removePropertyChangeListener(PropertyChangeListener listener);

    public abstract void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);

    public abstract boolean isDisableUrlEncoding();

    public abstract void setDisableUrlEncoding(boolean encode);
}
