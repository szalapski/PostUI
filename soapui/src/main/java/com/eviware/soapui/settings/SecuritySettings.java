

package com.eviware.soapui.settings;

import com.eviware.soapui.settings.Setting.SettingType;

public interface SecuritySettings {

    @Setting(name = "Password", description = "password for shadowing proxy password in settings file", type = SettingType.PASSWORD)
    String SHADOW_PASSWORD = SecuritySettings.class.getSimpleName() + "@" + "shadowProxyPassword";

    @Setting(name = "Disable the Load and Save scripts", description = "Do not run the Load and Save scripts on opening and saving projects", type = SettingType.BOOLEAN)
    String DISABLE_PROJECT_LOAD_SAVE_SCRIPTS = SecuritySettings.class.getSimpleName() + "@disable_project_load_save_scripts";
}
