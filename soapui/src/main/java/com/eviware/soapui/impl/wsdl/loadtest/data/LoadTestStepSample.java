

package com.eviware.soapui.impl.wsdl.loadtest.data;

import com.eviware.soapui.model.testsuite.TestStepResult;
import com.eviware.soapui.model.testsuite.TestStepResult.TestStepStatus;

/**
 * Base class for a LoadTest sample
 *
 * @author Ole.Matzura
 */

public class LoadTestStepSample {
    private long size;
    private TestStepStatus status;
    private long timeTaken;
    private String[] messages;
    private long timeStamp;

    LoadTestStepSample(TestStepResult result) {
        size = result.getSize();
        status = result.getStatus();
        timeTaken = result.getTimeTaken();
        messages = result.getMessages();
        timeStamp = result.getTimeStamp();
    }

    public String[] getMessages() {
        return messages.clone();
    }

    public long getSize() {
        return size;
    }

    public TestStepStatus getStatus() {
        return status;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public long getTimeTaken() {
        return timeTaken;
    }
}
