

package com.eviware.soapui.impl.rest.actions.oauth;

/**
 * Defines an object observing the SoapUI browser component.
 */
public interface BrowserListener {
    void locationChanged(String newLocation);

    void contentChanged(String newContent);

    void javaScriptExecuted(String script, String location, Exception error);

    void browserClosed();
}
