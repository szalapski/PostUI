

package com.eviware.soapui.plugins;

public interface PluginListener {

    void pluginUnloaded(Plugin plugin);

    void pluginLoaded(Plugin plugin);
}
