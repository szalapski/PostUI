

package com.eviware.soapui.impl.wsdl.submit.filters;

import com.eviware.soapui.impl.support.AbstractHttpRequest;
import com.eviware.soapui.impl.wsdl.submit.transports.http.BaseHttpRequestTransport;
import com.eviware.soapui.model.iface.SubmitContext;
import com.eviware.soapui.model.propertyexpansion.PropertyExpander;
import com.eviware.soapui.model.propertyexpansion.PropertyExpansionUtils;
import com.eviware.soapui.model.propertyexpansion.resolvers.ResolverUtils;
import com.eviware.soapui.settings.CommonSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * RequestFilter that expands properties in request content
 *
 * @author Ole.Matzura
 */

public class PropertyExpansionRequestFilter extends AbstractRequestFilter {
    public final static Logger log = LogManager.getLogger(PropertyExpansionRequestFilter.class);

    @Override
    public void filterAbstractHttpRequest(SubmitContext context, AbstractHttpRequest<?> request) {
        String content = (String) context.getProperty(BaseHttpRequestTransport.REQUEST_CONTENT);
        if (content == null) {
            log.warn("Missing request content in context, skipping property expansion");
        } else {
            content = PropertyExpander.expandProperties(context, content,
                    request.getSettings().getBoolean(CommonSettings.ENTITIZE_PROPERTIES));

            if (content != null) {
                context.setProperty(BaseHttpRequestTransport.REQUEST_CONTENT, content);
            }
        }
    }

    /**
     * @deprecated
     */

    public static String expandProperties(SubmitContext context, String content) {
        return PropertyExpander.expandProperties(context, content);
    }

    /**
     * @deprecated
     */

    public static String getGlobalProperty(String propertyName) {
        return PropertyExpansionUtils.getGlobalProperty(propertyName);
    }

    /**
     * @deprecated Use
     *             {@link ResolverUtils#extractXPathPropertyValue(Object, String)}
     *             instead
     */
    public static String extractXPathPropertyValue(Object property, String xpath) {
        return ResolverUtils.extractXPathPropertyValue(property, xpath);
    }
}
