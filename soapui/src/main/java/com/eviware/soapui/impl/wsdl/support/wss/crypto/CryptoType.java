

package com.eviware.soapui.impl.wsdl.support.wss.crypto;

/**
 * @author Erik R. Yverling
 */
public enum CryptoType {
    KEYSTORE {
        public String toString() {
            return "Keystore";
        }
    },

    TRUSTSTORE {
        public String toString() {
            return "Truststore";
        }
    }
}
