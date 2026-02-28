

package com.eviware.soapui.impl.wsdl.support.http;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * This request interceptor checks if wrapper request have more http headers. If
 * that is true then it copies those headers in original request. This way they
 * will be visible in raw request and accessible for users in Groovy scripts.
 *
 * @author robert.nemet
 */
public class HeaderRequestInterceptor implements HttpRequestInterceptor {
    public static final String SOAPUI_REQUEST_HEADERS = "soapui.request.headers";

    @Override
    public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
        List<Header> wHeaders = Arrays.asList(request.getAllHeaders());
        context.setAttribute(SOAPUI_REQUEST_HEADERS, wHeaders);
    }
}
