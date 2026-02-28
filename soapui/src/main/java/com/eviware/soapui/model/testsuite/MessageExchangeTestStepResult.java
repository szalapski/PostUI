

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.iface.MessageExchange;

public interface MessageExchangeTestStepResult extends TestStepResult {
    public MessageExchange[] getMessageExchanges();

    //public SoapUIMetrics getMetrics();
}
