

package com.eviware.soapui.ui.desktop;

import com.eviware.soapui.model.workspace.Workspace;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry of available desktops
 *
 * @author ole.matzura
 */

public class DesktopRegistry {
    private static DesktopRegistry instance;
    private Map<String, DesktopFactory> factories = new HashMap<>();

    public static DesktopRegistry getInstance() {
        if (instance == null) {
            instance = new DesktopRegistry();
        }

        return instance;
    }

    public void addDesktop(String name, DesktopFactory factory) {
        factories.put(name, factory);
    }

    public String[] getNames() {
        return factories.keySet().toArray(new String[factories.size()]);
    }

    public SoapUIDesktop createDesktop(String desktopType, Workspace workspace) {
        if (factories.containsKey(desktopType)) {
            return factories.get(desktopType).createDesktop(workspace);
        }

        return null;
    }
}
