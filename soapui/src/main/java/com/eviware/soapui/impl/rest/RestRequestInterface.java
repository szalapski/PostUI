

package com.eviware.soapui.impl.rest;

import com.eviware.soapui.config.RestRequestConfig;
import com.eviware.soapui.impl.support.http.HttpRequestInterface;
import com.eviware.soapui.impl.wsdl.submit.transports.http.HttpResponse;
import com.eviware.soapui.model.iface.SubmitContext;

import java.beans.PropertyChangeListener;

public interface RestRequestInterface extends HttpRequestInterface<RestRequestConfig>, PropertyChangeListener {

    /**
     * Each value in this enumeration represents an officially supported HTTP method ("verb").
     */
    enum HttpMethod {
        GET, POST, PUT, DELETE, HEAD, OPTIONS, TRACE, PATCH, PROPFIND, LOCK, UNLOCK, COPY, PURGE;

        public static String[] getMethodsAsStringArray() {
            return new String[]{GET.toString(), POST.toString(), PUT.toString(), DELETE.toString(), HEAD.toString(),
                    OPTIONS.toString(), TRACE.toString(), PATCH.toString(), PROPFIND.toString(), LOCK.toString(), UNLOCK.toString(),
                    COPY.toString(), PURGE.toString()};
        }

        public static HttpMethod[] getMethods() {
            return new HttpMethod[]{GET, POST, PUT, DELETE, HEAD, OPTIONS, TRACE, PATCH, PROPFIND, LOCK, UNLOCK, COPY, PURGE};
        }
    }

    public static final String DEFAULT_MEDIATYPE = "application/xml";
    public static final String REST_XML_REQUEST = "restXmlRequest";

    RestMethod getRestMethod();

    RestRepresentation[] getRepresentations();

    RestRepresentation[] getRepresentations(RestRepresentation.Type type);

    RestRepresentation[] getRepresentations(RestRepresentation.Type type, String mediaType);

    String getAccept();

    void setAccept(String acceptEncoding);

    String[] getResponseMediaTypes();

    RestResource getResource();

    void setPath(String fullPath);

    void setResponse(HttpResponse response, SubmitContext context);

    void release();

    boolean hasEndpoint();

}
