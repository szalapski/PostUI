

package com.eviware.soapui.support;

import java.beans.PropertyChangeListener;

/**
 * Behaviour for a class that notifies property changes
 *
 * @author Ole.Matzura
 */

public interface PropertyChangeNotifier {
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);

    public void addPropertyChangeListener(PropertyChangeListener listener);

    public void removePropertyChangeListener(PropertyChangeListener listener);

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);
}
