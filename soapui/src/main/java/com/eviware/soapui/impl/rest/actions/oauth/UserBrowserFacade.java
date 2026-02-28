

package com.eviware.soapui.impl.rest.actions.oauth;

import java.net.URL;

/**
 * Defines interactions with a web browser in the context of an OAuth2
 */
public interface UserBrowserFacade {

    void open(URL url);

    void addBrowserListener(BrowserListener listener);

    void removeBrowserStateListener(BrowserListener listener);

    void close();

    void executeJavaScript(String script);
}
