

package com.eviware.soapui.model.iface;

import com.eviware.soapui.support.types.StringToStringsMap;

/**
 * Request Response behaviour
 *
 * @author Ole.Matzura
 */

public interface Response extends TypedContent {
    public Request getRequest();

    public String getRequestContent();

    public long getTimeTaken();

    public Attachment[] getAttachments();

    public Attachment[] getAttachmentsForPart(String partName);

    public StringToStringsMap getRequestHeaders();

    public StringToStringsMap getResponseHeaders();

    public long getTimestamp();

    public byte[] getRawRequestData();

    public byte[] getRawResponseData();

    public String getContentAsXml();

    public String getProperty(String name);

    public void setProperty(String name, String value);

    public String[] getPropertyNames();
}
