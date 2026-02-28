

package com.eviware.soapui.plugins;

import java.util.List;

public class DependencyStatus {

    private final boolean installable;
    private final List<PluginInfo> dependenciesToInstall;

    public DependencyStatus(boolean installable, List<PluginInfo> dependenciesToInstall) {
        this.dependenciesToInstall = dependenciesToInstall;
        this.installable = installable;
    }

    public boolean isInstallable() {
        return installable;
    }

    public List<PluginInfo> getDependenciesToInstall() {
        return dependenciesToInstall;
    }
}
