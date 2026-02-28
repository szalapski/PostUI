

package com.eviware.soapui;

public class SwingPluginSoapUICore extends SwingSoapUICore {
    public SwingPluginSoapUICore() {
        this(System.getProperty("user.home", "."), SoapUICore.DEFAULT_SETTINGS_FILE);
    }

    public SwingPluginSoapUICore(String root) {
        this(root, SoapUICore.DEFAULT_SETTINGS_FILE);
    }

    public SwingPluginSoapUICore(String root, String settingsFile) {
        super(root, settingsFile);

        prepareUI();
        SoapUI.setSoapUICore(this);
    }

    @Override
    protected String importSettingsOnStartup(String fileName) throws Exception {
        return fileName;
    }
}
