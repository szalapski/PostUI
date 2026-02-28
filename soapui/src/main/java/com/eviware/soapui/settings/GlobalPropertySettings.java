

package com.eviware.soapui.settings;

public interface GlobalPropertySettings {
    public static final String PROPERTIES = GlobalPropertySettings.class.getSimpleName() + "@properties";
    public final static String ENABLE_OVERRIDE = GlobalPropertySettings.class.getSimpleName() + "@enableOverride";
    public static final String SECURITY_CHECKS_PROPERTIES = GlobalPropertySettings.class.getSimpleName()
            + "@security_scans_properties";
}
