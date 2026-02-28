

package com.eviware.soapui.model.settings;

/**
 * Listener for handling changes to a setting
 *
 * @author Ole.Matzura
 */

public interface SettingsListener {
    public void settingChanged(String name, String newValue, String oldValue);

    public void settingsReloaded();
}
