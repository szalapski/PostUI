

package com.eviware.soapui.impl.wsdl.monitor;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.support.Tools;

import javax.activation.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * DataSource for a MockRequest
 *
 * @author ole.matzura
 */

public class MonitorMessageExchangeDataSource implements DataSource {
    private byte[] data;
    private String contentType;
    private String name;

    public MonitorMessageExchangeDataSource(String name, InputStream in, String contentType) {
        try {
            data = Tools.readAll(in, 0).toByteArray();
            this.contentType = contentType;
            this.name = name;
        } catch (Exception e) {
            SoapUI.logError(e);
        }
    }

    public String getContentType() {
        return contentType;
    }

    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(data);
    }

    public String getName() {
        return name;
    }

    public OutputStream getOutputStream() throws IOException {
        return null;
    }
}
