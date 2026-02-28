

package com.eviware.soapui.testondemand;

import com.eviware.soapui.SoapUI;
import com.google.common.base.Charsets;
import flex.messaging.util.URLDecoder;

import java.io.UnsupportedEncodingException;

/**
 * @author Erik R. Yverling
 *         <p/>
 *         An AlertSite location for running the Test On Demand.
 */
public class Location {
    private String code;
    private String name;
    private String[] serverIPAddresses;

    public Location(String code, String name, String[] serverIPAddresses) {
        this.code = code;
        this.name = name;
        this.serverIPAddresses = serverIPAddresses;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return getURLDecodedName();
    }

    public String[] getServerIPAddresses() {
        return serverIPAddresses;
    }

    private String getURLDecodedName() {
        // We'll return the encoded name if the decoding fails
        String decodedName = name;
        try {
            decodedName = URLDecoder.decode(name, Charsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            SoapUI.logError(e);
        }
        return decodedName;
    }

    @Override
    public String toString() {
        return getURLDecodedName();
    }
}
