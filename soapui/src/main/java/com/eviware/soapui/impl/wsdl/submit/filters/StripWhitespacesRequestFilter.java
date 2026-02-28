

package com.eviware.soapui.impl.wsdl.submit.filters;

import com.eviware.soapui.impl.support.AbstractHttpRequest;
import com.eviware.soapui.impl.wsdl.submit.transports.http.BaseHttpRequestTransport;
import com.eviware.soapui.model.iface.SubmitContext;
import com.eviware.soapui.support.xml.XmlUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * RequestFilter for stripping whitespaces
 *
 * @author Ole.Matzura
 */

public class StripWhitespacesRequestFilter extends AbstractRequestFilter {
    private final static Logger log = LogManager.getLogger(StripWhitespacesRequestFilter.class);

    public void filterAbstractHttpRequest(SubmitContext context, AbstractHttpRequest<?> wsdlRequest) {
        if (!wsdlRequest.isStripWhitespaces()) {
            return;
        }

        String content = (String) context.getProperty(BaseHttpRequestTransport.REQUEST_CONTENT);
        if (content == null) {
            log.warn("Missing request content in context, skipping stripWhitespaces");
        } else {
            content = XmlUtils.stripWhitespaces(content);
            context.setProperty(BaseHttpRequestTransport.REQUEST_CONTENT, content);
        }
    }
}
