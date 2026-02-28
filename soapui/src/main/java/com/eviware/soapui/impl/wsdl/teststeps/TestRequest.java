

package com.eviware.soapui.impl.wsdl.teststeps;

import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.model.testsuite.Assertable;
import com.eviware.soapui.model.testsuite.TestStep;

public interface TestRequest extends Request, Assertable {
    public TestStep getTestStep();

    public boolean isDiscardResponse();

    public WsdlMessageAssertion importAssertion(WsdlMessageAssertion source, boolean overwrite, boolean createCopy,
                                                String newName);

    public Response getResponse();
}
