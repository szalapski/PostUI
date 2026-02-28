

package com.eviware.soapui.impl.settings;

import com.eviware.soapui.model.settings.SettingsListener;

import java.lang.ref.WeakReference;

/**
 * Weak listener to settingChanged
 *
 * @author ole.matzura
 */

public final class WeakSettingsListener implements SettingsListener {
    private final WeakReference<SettingsListener> listenerReference;

    public WeakSettingsListener(SettingsListener listener) {
        listenerReference = new WeakReference<>(listener);
    }

    public void settingChanged(String name, String newValue, String oldValue) {
        if (listenerReference.get() != null) {
            listenerReference.get().settingChanged(name, newValue, oldValue);
        }
    }

    @Override
    public void settingsReloaded() {
        if (listenerReference.get() != null) {
            listenerReference.get().settingsReloaded();
        }

    }
}
