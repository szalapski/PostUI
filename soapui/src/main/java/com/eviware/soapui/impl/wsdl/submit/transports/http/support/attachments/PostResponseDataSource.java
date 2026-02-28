

package com.eviware.soapui.impl.wsdl.submit.transports.http.support.attachments;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.submit.transports.http.ExtendedHttpMethod;
import com.eviware.soapui.impl.wsdl.support.CompressionSupport;
import com.eviware.soapui.impl.wsdl.support.http.HttpClientSupport;
import com.eviware.soapui.settings.HttpSettings;

import javax.activation.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * DataSource for a standard POST response
 *
 * @author ole.matzura
 */

public class PostResponseDataSource implements DataSource {
    private final ExtendedHttpMethod postMethod;
    private byte[] data;

    public PostResponseDataSource(ExtendedHttpMethod postMethod) {
        this.postMethod = postMethod;

        try {
            data = postMethod.getResponseBody();

            if (!SoapUI.getSettings().getBoolean(HttpSettings.DISABLE_RESPONSE_DECOMPRESSION)
                    && postMethod.hasHttpResponse()) {
                String compressionAlg = HttpClientSupport.getResponseCompressionType(postMethod.getHttpResponse());
                if (compressionAlg != null) {
                    data = CompressionSupport.decompress(compressionAlg, data);
                }
            }
        } catch (Exception e) {
            SoapUI.logError(e);
        }
    }

    public long getDataSize() {
        return data == null ? -1 : data.length;
    }

    public String getContentType() {
        return postMethod.getResponseContentType();
    }

    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(data);
    }

    public String getName() {
        return postMethod.getRequestLine().getMethod() + " response for "
                + postMethod.getRequestLine().getUri().toString();
    }

    public OutputStream getOutputStream() throws IOException {
        return null;
    }

    public byte[] getData() {
        return data;
    }
}
