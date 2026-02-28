

package com.eviware.soapui.impl.wsdl.panels.support;

import com.eviware.soapui.impl.wsdl.loadtest.WsdlLoadTest;
import com.eviware.soapui.model.testsuite.LoadTestRunner;
import org.apache.logging.log4j.Logger;

public class MockLoadTestRunner extends AbstractMockTestRunner<WsdlLoadTest> implements LoadTestRunner {
    public MockLoadTestRunner(WsdlLoadTest modelItem, Logger logger) {
        super(modelItem, logger);
    }

    public WsdlLoadTest getLoadTest() {
        return getTestRunnable();
    }

    public float getProgress() {
        return 0;
    }

    public int getRunningThreadCount() {
        return (int) getLoadTest().getThreadCount();
    }

    public boolean hasStopped() {
        return false;
    }
}
