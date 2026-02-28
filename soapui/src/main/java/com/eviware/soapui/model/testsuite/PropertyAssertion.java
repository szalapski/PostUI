

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.iface.MessageExchange;
import com.eviware.soapui.model.iface.SubmitContext;
import com.eviware.soapui.model.testsuite.Assertable.AssertionStatus;

/**
 * Behaviour for a assertion for the property in the WsdlMessageAssertion
 *
 * @author nebojsa.tasic
 */
public interface PropertyAssertion {
    public AssertionStatus assertProperty(String propertyName, MessageExchange messageExchange, SubmitContext context);
}
