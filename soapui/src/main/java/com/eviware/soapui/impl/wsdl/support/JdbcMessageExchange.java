

package com.eviware.soapui.impl.wsdl.support;

import com.eviware.soapui.impl.wsdl.panels.teststeps.JdbcResponse;
import com.eviware.soapui.impl.wsdl.teststeps.JdbcRequestTestStep;
import com.eviware.soapui.model.iface.Response;

/**
 * @author ole.matzura
 */

public class JdbcMessageExchange extends AbstractNonHttpMessageExchange<JdbcRequestTestStep> {
    private final JdbcResponse response;

    public JdbcMessageExchange(JdbcRequestTestStep modelItem, JdbcResponse response) {
        super(modelItem);
        this.response = response;
    }

    @Override
    public Response getResponse() {
        return response;
    }

    public String getRequestContent() {
        return response.getRequestContent();
    }

    public String getResponseContent() {
        return response == null? null : response.getContentAsString();
    }

    public long getTimeTaken() {
        return response.getTimeTaken();
    }

    public long getTimestamp() {
        return response.getTimestamp();
    }

    public boolean hasRequest(boolean ignoreEmpty) {
        return true;
    }

    public boolean hasResponse() {
        return getResponseContent() != null;
    }

    public boolean isDiscarded() {
        return false;
    }

    public String getEndpoint() {
        // TODO Auto-generated method stub
        return null;
    }
}
