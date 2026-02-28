

package org.apache.http.localserver;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AUTH;
import org.apache.http.protocol.HttpContext;

public class ResponseBasicUnauthorized implements HttpResponseInterceptor {
    public void process(final HttpResponse response, final HttpContext context) throws HttpException, IOException {
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_UNAUTHORIZED) {
            response.addHeader(AUTH.WWW_AUTH, "Basic realm=\"test realm\"");
        }
    }

}
