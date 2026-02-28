

package com.eviware.soapui.impl.wsdl.submit.transports.http;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import java.security.Principal;
import java.security.cert.Certificate;

/**
 * Holder for SSL-Related details for a request/response interchange
 *
 * @author ole.matzura
 */

public class SSLInfo {
    private String cipherSuite;
    private Principal localPrincipal;
    private Certificate[] localCertificates;
    private Principal peerPrincipal;
    private Certificate[] peerCertificates;
    private boolean peerUnverified;

    public SSLInfo(SSLSession session) {
        cipherSuite = session.getCipherSuite();
        localPrincipal = session.getLocalPrincipal();
        localCertificates = session.getLocalCertificates();
        try {
            peerPrincipal = session.getPeerPrincipal();
            peerCertificates = session.getPeerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            peerUnverified = true;
        }
    }

    public String getCipherSuite() {
        return cipherSuite;
    }

    public Certificate[] getLocalCertificates() {
        return localCertificates;
    }

    public Principal getLocalPrincipal() {
        return localPrincipal;
    }

    public Certificate[] getPeerCertificates() {
        return peerCertificates;
    }

    public Principal getPeerPrincipal() {
        return peerPrincipal;
    }

    public boolean isPeerUnverified() {
        return peerUnverified;
    }
}
