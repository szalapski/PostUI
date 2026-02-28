

package com.eviware.soapui.impl.wsdl.support.wss;

import com.eviware.soapui.impl.wsdl.support.wss.crypto.CryptoType;
import org.apache.ws.security.WSSecurityException;
import org.apache.ws.security.components.crypto.Crypto;

public interface WssCrypto {
    String STATUS_OK = "OK";

    public Crypto getCrypto() throws WSSecurityException;

    public String getLabel();

    public WssContainer getWssContainer();

    public String getSource();

    public String getPassword();

    public String getStatus();

    public CryptoType getType();
}
