

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.impl.wsdl.teststeps.TestRequest;

public interface SamplerTestStep extends TestStep, Assertable {
    public TestRequest getTestRequest();

    public TestStep getTestStep();
}
