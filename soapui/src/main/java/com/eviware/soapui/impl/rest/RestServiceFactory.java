

package com.eviware.soapui.impl.rest;

import com.eviware.soapui.config.InterfaceConfig;
import com.eviware.soapui.config.RestServiceConfig;
import com.eviware.soapui.impl.InterfaceFactory;
import com.eviware.soapui.impl.wsdl.WsdlProject;

public class RestServiceFactory implements InterfaceFactory<RestService> {
    public final static String REST_TYPE = "rest";

    public RestService build(WsdlProject project, InterfaceConfig config) {
        return new RestService(project, (RestServiceConfig) config.changeType(RestServiceConfig.type));
    }

    public RestService createNew(WsdlProject project, String name) {
        RestServiceConfig config = (RestServiceConfig) project.getConfig().addNewInterface()
                .changeType(RestServiceConfig.type);
        RestService iface = new RestService(project, config);
        iface.setName(name);

        return iface;
    }
}
