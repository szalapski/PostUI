

package com.eviware.soapui.model.environment;

import com.eviware.soapui.config.EnvironmentEndpointConfig;

public interface Endpoint {

    public void setService(Service service);

    public Service getService();

    public EnvironmentEndpointConfig getConfig();

}
