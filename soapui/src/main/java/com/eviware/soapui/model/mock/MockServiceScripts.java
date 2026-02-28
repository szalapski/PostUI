

package com.eviware.soapui.model.mock;

import com.eviware.soapui.impl.wsdl.mock.WsdlMockRunContext;

public interface MockServiceScripts {
    public Object runStartScript(WsdlMockRunContext mockContext, MockRunner wsdlMockRunner) throws Exception;

    public String getStartScript();

    public void setStartScript(String script);

    public String getStopScript();

    public void setStopScript(String script);

    public Object runStopScript(WsdlMockRunContext mockContext, MockRunner mockRunner) throws Exception;

    public String getOnRequestScript();

    public void setOnRequestScript(String text);

    public Object runOnRequestScript(WsdlMockRunContext context, MockRequest request) throws Exception;

    public String getAfterRequestScript();

    public void setAfterRequestScript(String text);

    public Object runAfterRequestScript(WsdlMockRunContext context, MockResult request) throws Exception;
}
