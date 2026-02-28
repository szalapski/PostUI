

package com.eviware.soapui.impl.wsdl.monitor;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import org.apache.http.HttpRequest;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MonitorListenerAdapter implements MonitorListener {
    public void afterProxy(WsdlProject project, ServletRequest request, ServletResponse response, HttpRequest method,
                           WsdlMonitorMessageExchange capturedData) {
    }

    public void beforeProxy(WsdlProject project, ServletRequest request, ServletResponse response, HttpRequest method) {
    }

    public void onMessageExchange(WsdlMonitorMessageExchange messageExchange) {
    }

    public void onRequest(WsdlProject project, ServletRequest request, ServletResponse response) {
    }
}
