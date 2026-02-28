

package com.eviware.soapui.impl.wsdl.monitor;

import com.eviware.soapui.impl.wsdl.WsdlProject;

public interface SoapMonitorEngine {
    void start(WsdlProject project, int localPort, SoapMonitorListenerCallBack listenerCallBack);

    void stop();

    boolean isRunning();

    boolean isProxy();

    void setIncludedContentTypes(ContentTypes includedContentTypes);
}
