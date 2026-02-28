

package com.eviware.soapui.impl.support.http;

import com.eviware.soapui.impl.support.AbstractHttpRequest;
import com.eviware.soapui.model.testsuite.SamplerTestStep;

public interface HttpRequestTestStep extends SamplerTestStep {
    public AbstractHttpRequest<?> getHttpRequest();
}
