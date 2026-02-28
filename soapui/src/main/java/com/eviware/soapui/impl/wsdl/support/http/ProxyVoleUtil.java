

package com.eviware.soapui.impl.wsdl.support.http;

import com.btr.proxy.search.ProxySearch;
import com.btr.proxy.util.PlatformUtil;

/**
 * @author Joel
 */
public class ProxyVoleUtil {
    public ProxySearch createAutoProxySearch() {
        ProxySearch proxySearch = new ProxySearch();
        proxySearch.addStrategy(ProxySearch.Strategy.JAVA);
        proxySearch.addStrategy(ProxySearch.Strategy.ENV_VAR);
        if (PlatformUtil.getCurrentPlattform() != PlatformUtil.Platform.WIN) {
            proxySearch.addStrategy(ProxySearch.Strategy.BROWSER);
            // For Windows both BROWSER and OS_DEFAULT will end up with an IEProxySearchStrategy.
            // The call in createPacSelector to winHttpDetectAutoProxyConfigUrl is quite slow and we don't want to do it twice.
        }
        proxySearch.addStrategy(ProxySearch.Strategy.OS_DEFAULT);
        return proxySearch;
    }
}
