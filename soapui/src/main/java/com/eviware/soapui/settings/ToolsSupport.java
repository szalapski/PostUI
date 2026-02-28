

package com.eviware.soapui.settings;

import com.eviware.soapui.settings.impl.SettingsToolLocatorImpl;

/**
 * Utilities for working with Tools and their locations
 *
 * @author Lars Höidahl
 */

public class ToolsSupport {
    private static ToolLocator toolLocations = new SettingsToolLocatorImpl();

    public static void setToolLocator(ToolLocator locations) {
        toolLocations = locations;
    }

    public static ToolLocator getToolLocator() {
        return toolLocations;
    }
}
