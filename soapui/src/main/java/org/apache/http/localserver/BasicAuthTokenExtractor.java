

package org.apache.http.localserver;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolException;
import org.apache.http.auth.AUTH;
import org.apache.http.util.EncodingUtils;

public class BasicAuthTokenExtractor {

    public String extract(final HttpRequest request) throws HttpException {
        String auth = null;

        Header h = request.getFirstHeader(AUTH.WWW_AUTH_RESP);
        if (h != null) {
            String s = h.getValue();
            if (s != null) {
                auth = s.trim();
            }
        }

        if (auth != null) {
            int i = auth.indexOf(' ');
            if (i == -1) {
                throw new ProtocolException("Invalid Authorization header: " + auth);
            }
            String authscheme = auth.substring(0, i);
            if (authscheme.equalsIgnoreCase("basic")) {
                String s = auth.substring(i + 1).trim();
                try {
                    byte[] credsRaw = EncodingUtils.getAsciiBytes(s);
                    BinaryDecoder codec = new Base64();
                    auth = EncodingUtils.getAsciiString(codec.decode(credsRaw));
                } catch (DecoderException ex) {
                    throw new ProtocolException("Malformed BASIC credentials");
                }
            }
        }
        return auth;
    }

}
