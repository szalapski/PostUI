

package org.apache.http.localserver;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

public class RequestBasicAuth implements HttpRequestInterceptor {
    private final BasicAuthTokenExtractor authTokenExtractor;

    public RequestBasicAuth() {
        super();
        this.authTokenExtractor = new BasicAuthTokenExtractor();
    }

    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        context.setAttribute("creds", this.authTokenExtractor.extract(request));
    }

}
