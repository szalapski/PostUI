

package com.eviware.soapui.impl.wsdl.monitor;

import com.eviware.soapui.impl.wsdl.submit.AbstractWsdlMessageExchange;
import com.eviware.soapui.impl.wsdl.support.wss.IncomingWss;
import com.eviware.soapui.model.iface.Operation;

import java.net.URL;
import java.util.Map;

public abstract class WsdlMonitorMessageExchange extends AbstractWsdlMessageExchange<Operation> {
    public WsdlMonitorMessageExchange(Operation modelItem) {
        super(modelItem);
    }

    public abstract URL getTargetUrl();

    public abstract void discard();

    public abstract String getRequestHost();

    public abstract long getRequestContentLength();

    public abstract long getResponseContentLength();

    public abstract void prepare(IncomingWss incomingRequestWss, IncomingWss incomingResponseWss);

    public abstract String getRequestMethod();

    public abstract Map<String, String> getHttpRequestParameters();

    public abstract String getQueryParameters();
}
