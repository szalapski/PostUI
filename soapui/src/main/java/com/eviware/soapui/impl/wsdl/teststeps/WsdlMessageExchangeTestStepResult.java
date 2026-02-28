

package com.eviware.soapui.impl.wsdl.teststeps;

import com.eviware.soapui.model.iface.MessageExchange;
import com.eviware.soapui.model.testsuite.MessageExchangeTestStepResult;

import java.util.ArrayList;
import java.util.List;

public class WsdlMessageExchangeTestStepResult extends WsdlTestStepResult implements MessageExchangeTestStepResult {
    private List<MessageExchange> exchanges = new ArrayList<>();

    public WsdlMessageExchangeTestStepResult(WsdlTestStep testStep) {
        super(testStep);
    }

    public MessageExchange[] getMessageExchanges() {
        return exchanges == null ? new MessageExchange[0] : exchanges.toArray(new MessageExchange[exchanges.size()]);
    }

    public void addMessageExchange(MessageExchange messageExchange) {
        if (exchanges != null) {
            exchanges.add(messageExchange);
        }
    }

    public void addMessages(MessageExchange[] messageExchanges) {
        if (exchanges != null) {
            for (MessageExchange messageExchange : messageExchanges) {
                exchanges.add(messageExchange);
            }
        }
    }

    @Override
    public void discard() {
        super.discard();

        exchanges = null;
    }
}
