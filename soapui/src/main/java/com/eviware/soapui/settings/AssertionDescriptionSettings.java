

package com.eviware.soapui.settings;

import com.eviware.soapui.settings.Setting.SettingType;

public interface AssertionDescriptionSettings {

    @Setting(name = "Show assertion description", description = "show assertion description", type = SettingType.BOOLEAN)
    public final static String SHOW_ASSERTION_DESCRIPTION = AssertionDescriptionSettings.class.getSimpleName() + "@"
            + "show-assertion-description";

}
