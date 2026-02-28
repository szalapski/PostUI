

package com.eviware.soapui.model.environment;

import com.eviware.soapui.config.ServiceConfig;

public interface Service {

    public void setEnvironment(Environment environment);

    public Environment getEnvironment();

    public void setEndpoint(Endpoint endpoint);

    public Endpoint getEndpoint();

    public void release();

    public String getName();

    public ServiceConfig.Type.Enum getType();

}
