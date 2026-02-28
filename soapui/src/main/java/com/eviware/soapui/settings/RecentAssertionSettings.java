

package com.eviware.soapui.settings;

import com.eviware.soapui.settings.Setting.SettingType;

public interface RecentAssertionSettings {
    @Setting(name = "Recent assertions", description = "last recently used assertions", type = SettingType.STRINGLIST)
    public final static String RECENT_ASSERTIONS = RecentAssertionSettings.class.getSimpleName() + "@"
            + "recent-assertions";
}
