

package com.eviware.soapui.settings;

import com.eviware.soapui.settings.Setting.SettingType;

/**
 * Web Recording related settings constants
 *
 * @author dragica.soldo
 */

public interface VersionUpdateSettings {
    @Setting(name = "Check for new versions", description = "Automatically check for new versions of SoapUI", type = SettingType.BOOLEAN)
    public final static String AUTO_CHECK_VERSION_UPDATE = VersionUpdateSettings.class.getSimpleName() + "@"
            + "auto-check-version-update";

}
