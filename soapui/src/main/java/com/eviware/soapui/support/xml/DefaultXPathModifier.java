

package com.eviware.soapui.support.xml;

public class DefaultXPathModifier implements XPathModifier {
    private final String before;
    private final String after;

    public DefaultXPathModifier(String before, String after) {
        this.before = before;
        this.after = after;
    }

    public void afterSelector(StringBuffer xpath) {
        if (after != null) {
            xpath.append(after);
        }
    }

    public void beforeSelector(StringBuffer xpath) {
        if (before != null) {
            xpath.append(before);
        }
    }

}
