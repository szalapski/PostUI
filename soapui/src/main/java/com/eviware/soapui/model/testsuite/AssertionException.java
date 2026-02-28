

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.support.SoapUIException;

/**
 * Exception thrown during assertion
 *
 * @author Ole.Matzura
 */

public class AssertionException extends SoapUIException {
    private AssertionError[] errors;

    public AssertionException(AssertionError error) {
        this(new AssertionError[]{error});
    }

    public AssertionException(AssertionError[] errors) {
        this.errors = new AssertionError[errors.length];
        for (int c = 0; c < errors.length; c++) {
            this.errors[c] = errors[c];
        }
    }

    public int getErrorCount() {
        return errors.length;
    }

    public AssertionError getErrorAt(int c) {
        return errors[c];
    }

    public AssertionError[] getErrors() {
        return errors;
    }

    public String getMessage() {
        StringBuffer result = new StringBuffer();
        for (int c = 0; c < errors.length; c++) {
            if (c > 0) {
                result.append('\n');
            }
            result.append(errors[c].getMessage());
        }

        return result.toString();
    }

}
