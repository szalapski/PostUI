

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.iface.MessageExchange;

public interface ResponseAssertedMessageExchange extends MessageExchange {
    public AssertedXPath[] getAssertedXPathsForResponse();
}
