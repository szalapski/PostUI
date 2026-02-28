

package com.eviware.soapui.impl.wsdl.support.http;

import com.btr.proxy.util.UriFilter;

import java.net.URI;

/**
 * An UriFilter that accepts all schemes except the supplied ones.
 *
 * @author Joel
 */
class SchemeProxyFilter implements UriFilter {
    private String[] unacceptedSchemes;

    public SchemeProxyFilter(String... unacceptedSchemes) {
        this.unacceptedSchemes = unacceptedSchemes;
    }

    @Override
    public boolean accept(URI uri) {
        for (String unacceptedScheme : unacceptedSchemes) {
            if (unacceptedScheme.equalsIgnoreCase(uri.getScheme())) {
                return false;
            }
        }
        return true;
    }
}
