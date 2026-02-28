

package com.eviware.soapui.impl.wsdl.teststeps;

import com.eviware.soapui.support.StringUtils;

import static com.eviware.soapui.support.JsonUtil.seemsToBeJson;
import static com.eviware.soapui.support.xml.XmlUtils.seemsToBeXml;

public enum PathLanguage {

    XPATH("XPath"),
    XQUERY("XQuery"),
    JSONPATH("JSONPath");

    public static PathLanguage forContent(String content) {
        if (content != null) {
            if (seemsToBeJson(content)) {
                return PathLanguage.JSONPATH;
            } else if (seemsToBeXml(content)) {
                return PathLanguage.XPATH;
            }
        }

        return null;
    }

    public static PathLanguage fromDisplayName(String displayName) {
        if (!StringUtils.hasContent(displayName)) {
            return null;
        }

        for (PathLanguage pathLanguage : PathLanguage.values()) {
            if (pathLanguage.displayName.toLowerCase().equals(displayName.toLowerCase())) {
                return pathLanguage;
            }
        }
        return null;
    }

    private String displayName;

    PathLanguage(String displayName) {
        this.displayName = displayName;
    }


    @Override
    public String toString() {
        return displayName;
    }


}
