

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.iface.MessageExchange;

public interface RequestAssertedMessageExchange extends MessageExchange {
    public AssertedXPath[] getAssertedXPathsForRequest();
}
