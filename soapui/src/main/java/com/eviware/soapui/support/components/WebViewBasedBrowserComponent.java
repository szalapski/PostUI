
package com.eviware.soapui.support.components;

import com.eviware.soapui.impl.rest.actions.oauth.BrowserListener;

import java.awt.Component;

/**
 * @author joel.jonsson
 */
public interface WebViewBasedBrowserComponent {
    public enum PopupStrategy {
        INTERNAL_BROWSER_NEW_WINDOW, INTERNAL_BROWSER_REUSE_WINDOW, EXTERNAL_BROWSER, DISABLED
    }

    Component getComponent();

    void navigate(String url);

    void navigate(String url, String backupUrl);

    void setContent(String contentAsString);

    void setContent(String contentAsString, String contentType);

    void close(boolean cascade);

    void addBrowserStateListener(BrowserListener listener);

    void removeBrowserStateListener(BrowserListener listener);

    void executeJavaScript(String script);

    /**
     * Provides a JavaScript object <i>memberName</i> when the current page is successfully loaded which can be used to call
     * the <i>eventHandler</i>.
     *
     * @see netscape.javascript.JSObject#setMember()
     */
    void addJavaScriptEventHandler(String memberName, Object eventHandler);

    /**
     * @return an object which provides possibility to set any value of any input element on the page
     */
    default PagePropertyMapper getPagePropertyMapper() {
        return (name, newValue) -> {
        };
    }
}
