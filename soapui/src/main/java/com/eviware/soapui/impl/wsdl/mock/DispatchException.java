

package com.eviware.soapui.impl.wsdl.mock;

/**
 * Exception thrown during dispatching of HTTP Requests to a WsdlMockService
 *
 * @author ole.matzura
 */

public class DispatchException extends Exception {
    public DispatchException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public DispatchException(String arg0) {
        super(arg0);
    }

    public DispatchException(Throwable arg0) {
        super(arg0);
    }
}
