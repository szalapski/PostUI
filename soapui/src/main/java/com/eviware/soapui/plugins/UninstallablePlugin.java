

package com.eviware.soapui.plugins;

/**
 * A plugin implementing this interface can be uninstalled runtime, i.e. without restarting SoapUI. If no special
 * cleanup is required when uninstalling a plugin (apart from removing all the factories, actions etc. that it has
 * added to SoapUI), the interface can be implemented with a no-op method.
 */
public interface UninstallablePlugin extends Plugin {

    /**
     * Should return true if uninstall was successful and SoapUI does not need to be restarted.
     */

    boolean uninstall() throws Exception;
}
