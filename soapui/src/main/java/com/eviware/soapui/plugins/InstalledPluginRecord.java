

package com.eviware.soapui.plugins;

/**
 * Data structure holding a plugin an the class loader used to load it.
 */
class InstalledPluginRecord {
    final Plugin plugin;
    final JarClassLoader pluginClassLoader;

    public InstalledPluginRecord(Plugin plugin, JarClassLoader pluginClassLoader) {
        this.plugin = plugin;
        this.pluginClassLoader = pluginClassLoader;
    }


}
