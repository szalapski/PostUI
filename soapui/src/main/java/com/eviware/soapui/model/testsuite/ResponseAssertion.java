

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.iface.MessageExchange;
import com.eviware.soapui.model.iface.SubmitContext;
import com.eviware.soapui.model.testsuite.Assertable.AssertionStatus;

/**
 * Behaviour for a assertion for the response in a WsdlMessageExchange
 *
 * @author ole.matzura
 */

public interface ResponseAssertion {
    public AssertionStatus assertResponse(MessageExchange messageExchange, SubmitContext context);
}
