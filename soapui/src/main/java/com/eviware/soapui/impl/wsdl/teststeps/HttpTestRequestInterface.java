

package com.eviware.soapui.impl.wsdl.teststeps;

import com.eviware.soapui.config.AbstractRequestConfig;
import com.eviware.soapui.impl.support.http.HttpRequestInterface;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.iface.SubmitContext;

public interface HttpTestRequestInterface<T extends AbstractRequestConfig> extends TestRequest, HttpRequestInterface<T> {
    public static final String RESPONSE_PROPERTY = HttpTestRequestInterface.class.getName() + "@response";
    public static final String STATUS_PROPERTY = HttpTestRequestInterface.class.getName() + "@status";

    public void assertResponse(SubmitContext context);

    public String getResponseContentAsString();

    public void updateConfig(T request);

    public WsdlTestStep getTestStep();

    public WsdlTestCase getTestCase();
}
