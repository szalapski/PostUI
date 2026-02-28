

package com.eviware.soapui.impl.wsdl.monitor;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.iface.SoapUIListener;
import org.apache.http.HttpRequest;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface MonitorListener extends SoapUIListener {
    void onRequest(WsdlProject project, ServletRequest request, ServletResponse response);

    void onMessageExchange(WsdlMonitorMessageExchange messageExchange);

    void beforeProxy(WsdlProject project, ServletRequest request, ServletResponse response, HttpRequest httpRequest);

    void afterProxy(WsdlProject project, ServletRequest request, ServletResponse response, HttpRequest httpRequest,
                    WsdlMonitorMessageExchange capturedData);
}
