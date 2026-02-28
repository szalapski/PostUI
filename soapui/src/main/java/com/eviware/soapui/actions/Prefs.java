

package com.eviware.soapui.actions;

import com.eviware.soapui.model.settings.Settings;
import com.eviware.soapui.support.components.SimpleForm;
import com.eviware.soapui.support.types.StringToStringMap;

/**
 * Interface for a preferences page
 *
 * @author ole.matzura
 */

public interface Prefs {
    public SimpleForm getForm();

    public void setFormValues(Settings settings);

    public void getFormValues(Settings settings);

    public void storeValues(StringToStringMap values, Settings settings);

    public StringToStringMap getValues(Settings settings);

    public String getTitle();
}
