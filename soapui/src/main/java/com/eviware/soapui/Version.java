

package com.eviware.soapui;

public class Version {

    String[] versionComponents;

    public Version(String versionString) {
        if (versionString == null || !versionString.contains(".")) {
            versionComponents = new String[]{"0", "0"};
        } else {
            versionComponents = versionString.split("\\.|\\-");
        }
    }

    public String getMajorVersion() {
        return versionComponents[0] + "." + versionComponents[1];
    }

}
