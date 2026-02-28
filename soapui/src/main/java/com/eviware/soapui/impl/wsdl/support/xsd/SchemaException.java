

package com.eviware.soapui.impl.wsdl.support.xsd;

import java.util.ArrayList;

/**
 * Exception thrown by schema-related operations
 *
 * @author Ole.Matzura
 */

public class SchemaException extends Exception {
    private ArrayList<?> errorList;

    public SchemaException(String message, Throwable cause) {
        super(message, cause);
    }

    public SchemaException(Exception e, ArrayList<?> errorList) {
        this.errorList = errorList;
    }

    public ArrayList<?> getErrorList() {
        return errorList;
    }
}
