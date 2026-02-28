

package com.eviware.soapui.model.iface;

import java.io.InputStream;

/**
 * Attachment for Requests and their responses
 *
 * @author Ole.Matzura
 */

public interface Attachment {
    public String getName();

    public String getContentType();

    public void setContentType(String contentType);

    public long getSize();

    public String getPart();

    public void setPart(String part);

    public InputStream getInputStream() throws Exception;

    public String getUrl();

    public boolean isCached();

    public AttachmentType getAttachmentType();

    public enum AttachmentType {
        MIME, XOP, CONTENT, SWAREF, UNKNOWN
    }

    public String getContentID();

    public enum AttachmentEncoding {
        BASE64, HEX, NONE
    }

    public AttachmentEncoding getEncoding();

    public String getContentEncoding();

    public String getId();
}
