

package com.eviware.soapui.impl.wsdl.submit.filters;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.support.AbstractHttpRequest;
import com.eviware.soapui.impl.support.HttpUtils;
import com.eviware.soapui.impl.wsdl.submit.transports.http.BaseHttpRequestTransport;
import com.eviware.soapui.model.iface.SubmitContext;
import com.eviware.soapui.model.propertyexpansion.PropertyExpander;
import com.eviware.soapui.settings.HttpSettings;
import com.eviware.soapui.support.StringUtils;
import org.apache.commons.httpclient.URI;
import org.apache.http.client.methods.HttpRequestBase;

/**
 * RequestFilter that adds SOAP specific headers
 *
 * @author Ole.Matzura
 */

public class EndpointRequestFilter extends AbstractRequestFilter {
    @Override
    public void filterAbstractHttpRequest(SubmitContext context, AbstractHttpRequest<?> request) {
        HttpRequestBase httpMethod = (HttpRequestBase) context.getProperty(BaseHttpRequestTransport.HTTP_METHOD);

        String strURL = request.getEndpoint();
        strURL = PropertyExpander.expandProperties(context, strURL);
        try {
            if (StringUtils.hasContent(strURL)) {
                URI uri = new URI(strURL, request.getSettings().getBoolean(HttpSettings.ENCODED_URLS));
                context.setProperty(BaseHttpRequestTransport.REQUEST_URI, uri);
                httpMethod.setURI(HttpUtils.createUri(uri));
            }
        } catch (Exception e) {
            SoapUI.logError(e);
        }
    }
}
