

package com.eviware.soapui.model.support;

import com.eviware.soapui.model.iface.Operation;

public interface XPathReference {
    public String getXPath();

    public void setXPath(String xpath);

    public String getLabel();

    public Operation getOperation();

    public boolean isRequest();

    /**
     * Gets the property this xpath selects from
     */

    // public TestProperty getTargetProperty();

    /**
     * apply updates
     */

    public void update();
}
