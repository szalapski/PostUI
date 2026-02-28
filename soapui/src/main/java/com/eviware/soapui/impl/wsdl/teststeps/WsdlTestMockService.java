

package com.eviware.soapui.impl.wsdl.teststeps;

import com.eviware.soapui.config.MockServiceConfig;
import com.eviware.soapui.impl.wsdl.mock.WsdlMockService;

public class WsdlTestMockService extends WsdlMockService {
    private final WsdlMockResponseTestStep mockResponseStep;

    public WsdlTestMockService(WsdlMockResponseTestStep step, MockServiceConfig config) {
        super(step.getTestCase().getTestSuite().getProject(), config);
        this.mockResponseStep = step;
    }

    public WsdlMockResponseTestStep getMockResponseStep() {
        return mockResponseStep;
    }
}
