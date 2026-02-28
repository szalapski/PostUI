

package com.eviware.soapui.settings;

/**
 * Locates the specified tools in the current environment
 *
 * @author ole.matzura
 */

public interface ToolLocator {
    /**
     * Get the location of Ant.
     *
     * @param mandatory If mandatory==true and Ant is not found, show an error dialog.
     * @return
     */
    String getAntDir(boolean mandatory);

    String getJavacLocation(boolean mandatory);
}
