

package com.eviware.soapui.impl.wsdl.teststeps.assertions;

import com.eviware.soapui.model.testsuite.AssertionError;

/**
 * Exception thrown during assertion
 *
 * @author Ole.Matzura
 * @deprecated moved to com.eviware.soapui.model.testsuite.AssertionException
 */

public class AssertionException extends com.eviware.soapui.model.testsuite.AssertionException {
    public AssertionException(AssertionError[] errors) {
        super(errors);
    }

    public AssertionException(AssertionError error) {
        super(error);
    }
}
