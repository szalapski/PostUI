

package com.eviware.soapui.model.propertyexpansion;

import com.eviware.soapui.model.testsuite.TestProperty;

public interface MutablePropertyExpansion extends PropertyExpansion {
    public void setXPath(String xpath);

    public void setProperty(TestProperty property);

    public void update() throws Exception;
}
