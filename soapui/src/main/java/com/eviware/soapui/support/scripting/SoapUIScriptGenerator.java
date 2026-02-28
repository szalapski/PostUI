

package com.eviware.soapui.support.scripting;

import com.eviware.soapui.model.propertyexpansion.PropertyExpansion;
import com.eviware.soapui.support.xml.XPathData;

public interface SoapUIScriptGenerator {
    String createContextExpansion(String name, PropertyExpansion expansion);

    String createScriptAssertionForExists(XPathData xpathData);
}
