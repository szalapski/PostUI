

package com.eviware.soapui.settings;

import com.eviware.soapui.settings.Setting.SettingType;

/**
 * Project settings constants
 *
 * @author Ole.Matzura
 */

public interface ProjectSettings {
    @Setting(name = "ProjectRoot", description = "root folder of associated external project")
    public final static String PROJECT_ROOT = ProjectSettings.class.getSimpleName() + "@projectRoot";

    public final static String PROJECT_NATURE = ProjectSettings.class.getSimpleName() + "@projectNature";

    @Setting(name = "Shadowing Password", description = "password for shadowing project password", type = SettingType.PASSWORD)
    public final static String SHADOW_PASSWORD = ProjectSettings.class.getSimpleName() + "@" + "shadowPassword";

    @Setting(name = "Hermes Config", description = "hermes", type = SettingType.FOLDER)
    public final static String HERMES_CONFIG = ProjectSettings.class.getSimpleName() + "@" + "hermesConfig";

}
