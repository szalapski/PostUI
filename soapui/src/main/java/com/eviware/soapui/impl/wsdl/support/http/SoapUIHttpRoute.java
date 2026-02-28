

package com.eviware.soapui.impl.wsdl.support.http;

import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.util.LangUtils;

public class SoapUIHttpRoute {

    public static final String SOAPUI_SSL_CONFIG = "soapui.sslConfig";
    public static final String TESTSERVER_SSL_CONFIG = "testserver.sslConfig";
    private HttpRoute httpRoute;
    private String param;

    public SoapUIHttpRoute(HttpRoute httpRoute) {
        this.httpRoute = httpRoute;
    }

    public final boolean equals(Object o) {
        if (o instanceof SoapUIHttpRoute) {
            SoapUIHttpRoute obj = (SoapUIHttpRoute) o;
            HttpRoute that = obj.getHttpRoute();

            boolean result = httpRoute.equals(that);
            if (result) {
                return param.equals(obj.getParam());
            }
        }
        return false;
    }

    public String getParam() {
        return this.param;
    }

    public HttpRoute getHttpRoute() {
        return this.httpRoute;
    }

    public synchronized int hashCode() {
        int hash = httpRoute.hashCode();
        hash = LangUtils.hashCode(hash, param);
        return hash;
    }

}
