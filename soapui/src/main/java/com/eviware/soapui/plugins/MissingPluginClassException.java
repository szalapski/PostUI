

package com.eviware.soapui.plugins;

public class MissingPluginClassException extends RuntimeException {

    public MissingPluginClassException(String message) {
        super(message);
    }

    public MissingPluginClassException(String message, Throwable cause) {
        super(message, cause);
    }
}
