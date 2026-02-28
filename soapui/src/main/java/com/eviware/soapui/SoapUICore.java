
package com.eviware.soapui;

import com.eviware.soapui.model.settings.Settings;
import com.eviware.soapui.monitor.MockEngine;
import com.eviware.soapui.security.registry.SecurityScanRegistry;
import com.eviware.soapui.support.action.SoapUIActionRegistry;
import com.eviware.soapui.support.factory.SoapUIFactoryRegistry;
import com.eviware.soapui.support.listener.SoapUIListenerRegistry;

import java.io.File;

public interface SoapUICore {

    String DEFAULT_SETTINGS_FILE = "soapui-settings.xml";

    Settings getSettings();

    MockEngine getMockEngine();

    SoapUIListenerRegistry getListenerRegistry();

    SoapUIActionRegistry getActionRegistry();

    SoapUIFactoryRegistry getFactoryRegistry();

    String saveSettings() throws Exception;

    Settings importSettings(File file) throws Exception;

    SoapUIExtensionClassLoader getExtensionClassLoader();

    SecurityScanRegistry getSecurityScanRegistry();
}
