

package com.eviware.soapui.impl.support;

import com.eviware.soapui.config.AbstractRequestConfig;
import com.eviware.soapui.model.iface.Request;

public class EndpointSupport {
    public String getEndpoint(AbstractHttpRequest<AbstractRequestConfig> request) {
        return request.getConfig().getEndpoint();
    }

    public void setEndpoint(AbstractHttpRequest<AbstractRequestConfig> request, String endpoint) {
        String old = request.getEndpoint();
        if (old != null && old.equals(endpoint)) {
            return;
        }

        request.getConfig().setEndpoint(endpoint);
        request.notifyPropertyChanged(Request.ENDPOINT_PROPERTY, old, endpoint);
    }

}
