

package com.eviware.soapui.impl.wsdl.support.wss;

import com.eviware.soapui.config.WSSCryptoConfig;

public class WssCryptoRegistry // extends
// AbstractRegistry<WssCrypto,WSSCryptoConfig,WssContainer>
{
    private static WssCryptoRegistry instance;

    public WssCryptoRegistry() {
        // mapType( MerlinCrypto.TYPE, MerlinCrypto.class );
    }

    public static synchronized WssCryptoRegistry get() {
        if (instance == null) {
            instance = new WssCryptoRegistry();
        }

        return instance;
    }

    protected WSSCryptoConfig addNewConfig(WssContainer container) {
        return null; // ((DefaultWssContainer)container).getConfig().addNewCrypto();
    }
}
