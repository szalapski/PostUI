

package com.eviware.soapui.impl.wsdl.teststeps;

import com.eviware.soapui.config.RestRequestStepConfig;
import com.eviware.soapui.impl.rest.RestMethod;
import com.eviware.soapui.impl.rest.RestResource;
import com.eviware.soapui.model.testsuite.Assertable;
import com.eviware.soapui.model.testsuite.OperationTestStep;

public interface RestTestRequestStepInterface extends HttpTestRequestStepInterface, OperationTestStep, Assertable {
    public RestRequestStepConfig getRequestStepConfig();

    public String getService();

    public String getResourcePath();

    public RestMethod getRestMethod();

    public RestResource getResource();
}
