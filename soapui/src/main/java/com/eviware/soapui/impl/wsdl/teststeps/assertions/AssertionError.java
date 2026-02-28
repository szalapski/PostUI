

package com.eviware.soapui.impl.wsdl.teststeps.assertions;

import org.apache.xmlbeans.XmlError;

/**
 * Holder for an assertion error, deprecated since this class has moved
 *
 * @author Ole.Matzura
 * @deprecated moved to com.eviware.soapui.model.testsuite.AssertionError
 */

public class AssertionError extends com.eviware.soapui.model.testsuite.AssertionError {
    public AssertionError(String message) {
        super(message);
    }

    public AssertionError(XmlError xmlError) {
        super(xmlError);
    }
}
