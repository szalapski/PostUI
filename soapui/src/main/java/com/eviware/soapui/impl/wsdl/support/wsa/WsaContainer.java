

package com.eviware.soapui.impl.wsdl.support.wsa;

import com.eviware.soapui.impl.wsdl.WsdlOperation;

public interface WsaContainer {
    boolean isWsaEnabled();

    void setWsaEnabled(boolean arg0);

    WsaConfig getWsaConfig();

    WsdlOperation getOperation();

    void setOperation(WsdlOperation operation);

}
