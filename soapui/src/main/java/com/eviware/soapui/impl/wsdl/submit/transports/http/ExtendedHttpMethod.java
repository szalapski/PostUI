

package com.eviware.soapui.impl.wsdl.submit.transports.http;

import com.eviware.soapui.impl.wsdl.submit.transports.http.support.metrics.SoapUIMetrics;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpUriRequest;

import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public interface ExtendedHttpMethod extends HttpRequest, HttpUriRequest {
    long getMaxSize();

    void setMaxSize(long maxSize);

    long getResponseReadTime();

    long getResponseReadTimeNanos();

    void initStartTime();

    long getTimeTaken();

    long getStartTime();

    SSLInfo getSSLInfo();

    String getResponseCharSet();

    String getResponseContentType();

    String getMethod();

    void setDumpFile(String dumpFile);

    void setFailed(Throwable t);

    boolean isFailed();

    Throwable getFailureCause();

    boolean hasResponse();

    byte[] getDecompressedResponseBody() throws IOException;

    void setDecompress(boolean decompress);

    void setURI(URI uri);

    void setHttpResponse(org.apache.http.HttpResponse httpResponse);

    org.apache.http.HttpResponse getHttpResponse();

    boolean hasHttpResponse();

    byte[] getResponseBody() throws IOException;

    String getResponseBodyAsString() throws IOException;

    HttpEntity getRequestEntity();

    void afterReadResponse(SSLSession session);

    void afterWriteRequest();

    SoapUIMetrics getMetrics();

    Header[] getAllResponseHeaders();

    URL getURL() throws MalformedURLException;
}
