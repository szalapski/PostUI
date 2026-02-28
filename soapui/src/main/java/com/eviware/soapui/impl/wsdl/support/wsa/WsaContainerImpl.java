

package com.eviware.soapui.impl.wsdl.support.wsa;

import com.eviware.soapui.impl.wsdl.WsdlOperation;

public class WsaContainerImpl implements WsaContainer {

    WsdlOperation operation;
    WsaConfig wsaConfig;
    boolean enabled = false;

    public WsdlOperation getOperation() {
        return operation;
    }

    public WsaConfig getWsaConfig() {
        return wsaConfig;
    }

    public boolean isWsaEnabled() {
        return enabled;
    }

    public void setWsaEnabled(boolean arg0) {
        enabled = arg0;

    }

    public void setOperation(WsdlOperation operation) {
        this.operation = operation;

    }

}
