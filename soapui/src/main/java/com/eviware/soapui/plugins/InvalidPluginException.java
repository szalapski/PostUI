

package com.eviware.soapui.plugins;

public class InvalidPluginException extends RuntimeException {

    public InvalidPluginException(String message) {
        super(message);
    }

    public InvalidPluginException(String message, Throwable cause) {
        super(message, cause);
    }
}
