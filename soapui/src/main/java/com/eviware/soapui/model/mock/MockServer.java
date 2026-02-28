

package com.eviware.soapui.model.mock;

import com.eviware.soapui.impl.wsdl.mock.WsdlMockRunContext;

public interface MockServer {

    public String getPath();

    public void setPath(String path);

    public int getPort();

    public void setPort(int i);

    public MockRunner getMockRunner();

    public MockRunner start() throws Exception;

    /**
     * Start this mock service if HttpSetting.START_MOCK_SERVICE is true.
     *
     * @throws Exception if the start fails for some reason. One case may be that the port is occupied already.
     */
    public void startIfConfigured() throws Exception;

    public boolean getBindToHostOnly();

    public String getLocalEndpoint();

    public MockDispatcher createDispatcher(WsdlMockRunContext mockContext);

    public String getHost();

    public void addMockRunListener(MockRunListener listener);

    public void removeMockRunListener(MockRunListener listener);

    public MockRunListener[] getMockRunListeners();

}
