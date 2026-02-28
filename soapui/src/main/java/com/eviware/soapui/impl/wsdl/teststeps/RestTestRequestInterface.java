

package com.eviware.soapui.impl.wsdl.teststeps;

import com.eviware.soapui.config.RestRequestConfig;
import com.eviware.soapui.impl.rest.RestMethod;
import com.eviware.soapui.impl.rest.RestRequestInterface;
import com.eviware.soapui.support.resolver.ResolveContext;

public interface RestTestRequestInterface extends HttpTestRequestInterface<RestRequestConfig>, RestRequestInterface {
    public WsdlMessageAssertion importAssertion(WsdlMessageAssertion source, boolean overwrite, boolean createCopy,
                                                String newName);

    public void setRestMethod(RestMethod restMethod);

    public String getRestMethodName();

    public void resolve(ResolveContext<?> context);

    public String getServiceName();

    public RestTestRequestStep getTestStep();
}
