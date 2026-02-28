

package com.eviware.soapui.plugins;

/**
 * Actions and factories that implements this interface will get a reference to the plugin itself when they are loaded
 * by PluginLoader. This is useful to access common components and shared state without having to resort to static
 * fields.
 * @see PluginLoader
 */
public interface PluginAware {

    /**
     * Setter used to pass a reference to the plugin into the plugin component class (action or factory)
     * @param plugin the Plugin class with which this class is associated
     */
    void setPlugin(Plugin plugin);
}
