

package com.eviware.soapui.support.action;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.PropertyChangeNotifier;

/**
 * An action for a ModelItem
 *
 * @author ole.matzura
 */

public interface SoapUIAction<T extends ModelItem> extends PropertyChangeNotifier {
    public final static String ENABLED_PROPERTY = SoapUIAction.class.getName() + "@enabled";

    public void perform(T target, Object param);

    public String getId();

    public String getName();

    public String getDescription();

    public boolean isEnabled();

    public boolean isDefault();

    public boolean applies(T target);
}
