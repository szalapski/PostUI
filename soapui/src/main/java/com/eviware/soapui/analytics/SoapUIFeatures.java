

package com.eviware.soapui.analytics;

/**
 *
 */
public enum SoapUIFeatures {
    INSTALL("InstallProduct"),
    SERVICE_VIRTUALIZATION("ServiceVirtualization"),
    FUNCTIONAL_TESTING("FunctionalTesting"),
    PERFORMANCE_TESTING("PerformanceTesting"),
    SECURITY_TESTING("SecurityTesting"),
    SOAP("SOAP"),
    REST("REST"),
    MONITORING("Monitoring"),
    AUTOMATE_SOAP_UI("AutomateSoapUI"),
    USE_SOAP_UI("UseSoapUI"),
    TOOL("Tool");

    private String featureName;

    SoapUIFeatures(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureName() {
        return featureName;
    }
}
