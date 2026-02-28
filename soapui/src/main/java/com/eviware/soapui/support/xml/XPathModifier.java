

package com.eviware.soapui.support.xml;

public interface XPathModifier {
    void beforeSelector(StringBuffer xpath);

    void afterSelector(StringBuffer xpath);
}
