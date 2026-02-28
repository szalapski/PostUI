

package com.eviware.soapui.support;

/**
 * General SoapUI exception class
 *
 * @author Ole.Matzura
 */

public class SoapUIException extends Exception {
    public SoapUIException() {
        super();
    }

    public SoapUIException(String message) {
        super(message);
    }

    public SoapUIException(String message, Throwable cause) {
        super(message, cause);
    }

    public SoapUIException(Throwable cause) {
        super(cause);
    }
}
