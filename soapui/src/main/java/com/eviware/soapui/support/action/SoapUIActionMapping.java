

package com.eviware.soapui.support.action;

import com.eviware.soapui.model.ModelItem;

/**
 * The mapping of a SoapUIAction into a SoapUIActionGroup
 *
 * @author ole.matzura
 */

public interface SoapUIActionMapping<T extends ModelItem> {
    public SoapUIAction<T> getAction();

    public String getActionId();

    public String getName();

    public String getDescription();

    public boolean isDefault();

    public boolean isEnabled();

    public String getIconPath();

    public String getKeyStroke();

    public Object getParam();

    public SoapUIActionMapping<T> setName(String name);

    public SoapUIActionMapping<T> setDescription(String description);

    public SoapUIActionMapping<T> setParam(Object param);

    public SoapUIActionMapping<T> setEnabled(boolean enabled);

    int getToolbarIndex();
}
