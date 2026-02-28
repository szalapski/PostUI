

package com.eviware.soapui.model.support;

import com.eviware.soapui.model.iface.MessageExchange;
import com.eviware.soapui.model.testsuite.TestStepResult;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class MessageExchangeUtil {
    public static MessageExchange findMessageExchangeByTestStepId(List<TestStepResult> results, String testStepId) {
        List<TestStepResult> tmpList = Lists.newArrayList(results);
        Collections.reverse(tmpList);

        for (TestStepResult tsr : tmpList) {
            String id = tsr.getTestStep().getId();
            if (id.equals(testStepId) && tsr instanceof MessageExchange) {
                return (MessageExchange) tsr;
            }
        }
        return null;

    }
}
