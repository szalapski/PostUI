

package com.eviware.soapui.model.environment;

import com.eviware.soapui.model.iface.SoapUIListener;

public interface EnvironmentListener extends SoapUIListener {

    public void propertyValueChanged(Property property);

}
