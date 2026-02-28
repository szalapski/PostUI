

package com.eviware.soapui.impl.wsdl.submit.transports.http.support.attachments;

import com.eviware.soapui.model.iface.Attachment;

import javax.activation.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Standard DataSource for existing attachments in SoapUI
 *
 * @author ole.matzura
 */

public class AttachmentDataSource implements DataSource {
    private final Attachment attachment;

    public AttachmentDataSource(Attachment attachment) {
        this.attachment = attachment;
    }

    public String getContentType() {
        return attachment.getContentType();
    }

    public InputStream getInputStream() throws IOException {
        try {
            return attachment.getInputStream();
        } catch (Exception e) {
            throw new IOException(e.toString());
        }
    }

    public String getName() {
        return attachment.getName();
    }

    public OutputStream getOutputStream() throws IOException {
        return null;
    }
}
