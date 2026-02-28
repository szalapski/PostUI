

package com.eviware.soapui.impl.wsdl.submit.transports.http;

import com.eviware.soapui.impl.wsdl.submit.RequestTransport;

/**
 * Base for HTTP transports
 *
 * @author Ole.Matzura
 */

public interface BaseHttpRequestTransport extends RequestTransport {
    public static final String HTTP_METHOD = "httpMethod";
    public static final String POST_METHOD = "postMethod";
    public static final String HTTP_CLIENT = "httpClient";
    //public static final String HOST_CONFIGURATION = "hostConfiguration";
    public static final String REQUEST_URI = "requestUri";
    public static final String REQUEST_CONTENT = "requestContent";
    public static final String RESPONSE = "httpResponse";
    public static final String RESPONSE_PROPERTIES = "httpResponseProperties";
    //public static final String SOAPUI_SSL_CONFIG = "soapui.sslConfig";
}
