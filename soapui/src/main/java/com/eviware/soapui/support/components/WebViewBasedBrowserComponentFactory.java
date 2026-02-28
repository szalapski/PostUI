

package com.eviware.soapui.support.components;

import com.eviware.soapui.SoapUI;

/**
 * @author joel.jonsson
 */
public class WebViewBasedBrowserComponentFactory {
    /*
    This factory  resides in a separate class to avoid ClassNotFoundException when jfxrt.jar in unavailable
    and browser component is disabled.
     */
    public static WebViewBasedBrowserComponent createBrowserComponent(boolean addNavigationBar) {
        return createBrowserComponent(addNavigationBar, WebViewBasedBrowserComponent.PopupStrategy.INTERNAL_BROWSER_NEW_WINDOW);
    }

    public static WebViewBasedBrowserComponent createBrowserComponent(boolean addNavigationBar, WebViewBasedBrowserComponent.PopupStrategy popupStrategy) {
        if (SoapUI.isBrowserDisabled()) {
            return new DisabledWebViewBasedBrowserComponent();
        } else {
            return new EnabledWebViewBasedBrowserComponent(addNavigationBar, popupStrategy);
        }
    }
}
