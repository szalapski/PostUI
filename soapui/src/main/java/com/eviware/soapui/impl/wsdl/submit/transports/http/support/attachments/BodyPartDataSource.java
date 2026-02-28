

package com.eviware.soapui.impl.wsdl.submit.transports.http.support.attachments;

import com.eviware.soapui.SoapUI;

import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * DataSource for a BodyPart
 *
 * @author ole.matzura
 */

public class BodyPartDataSource implements DataSource {
    private final BodyPart bodyPart;

    public BodyPartDataSource(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getContentType() {
        try {
            return bodyPart.getContentType();
        } catch (MessagingException e) {
            SoapUI.logError(e);
            return null;
        }
    }

    public InputStream getInputStream() throws IOException {
        try {
            return bodyPart.getInputStream();
        } catch (MessagingException e) {
            SoapUI.logError(e);
            return null;
        }
    }

    public String getName() {
        try {
            return bodyPart.getHeader("Content-ID")[0];
        } catch (MessagingException e) {
            SoapUI.logError(e);
            return null;
        }
    }

    public OutputStream getOutputStream() throws IOException {
        return null;
    }

}
