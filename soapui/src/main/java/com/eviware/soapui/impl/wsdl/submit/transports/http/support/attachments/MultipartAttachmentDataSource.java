

package com.eviware.soapui.impl.wsdl.submit.transports.http.support.attachments;

import com.eviware.soapui.SoapUI;

import javax.activation.DataSource;
import javax.mail.internet.MimeMultipart;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * DataSource for multipart attachments
 *
 * @author ole.matzura
 */

public class MultipartAttachmentDataSource implements DataSource {
    private final MimeMultipart multipart;

    public MultipartAttachmentDataSource(MimeMultipart multipart) {
        this.multipart = multipart;
    }

    public String getContentType() {
        return multipart.getContentType();
    }

    public InputStream getInputStream() throws IOException {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            multipart.writeTo(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception e) {
            SoapUI.logError(e);
            return null;
        }
    }

    public String getName() {
        return multipart.toString();
    }

    public OutputStream getOutputStream() throws IOException {
        return null;
    }
}
