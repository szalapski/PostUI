

package com.eviware.soapui.model.iface;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.testsuite.ResultContainer;
import com.eviware.soapui.support.types.StringToStringMap;
import com.eviware.soapui.support.types.StringToStringsMap;

/**
 * An exchange of a request and response message
 *
 * @author ole.matzura
 */

public interface MessageExchange extends ResultContainer {
    public Operation getOperation();

    public ModelItem getModelItem();

    public long getTimestamp();

    public long getTimeTaken();

    public String getEndpoint();

    public StringToStringMap getProperties();

    public String getRequestContent();

    public String getResponseContent();

    public String getRequestContentAsXml();

    public String getResponseContentAsXml();

    public StringToStringsMap getRequestHeaders();

    public StringToStringsMap getResponseHeaders();

    public Attachment[] getRequestAttachments();

    public Attachment[] getResponseAttachments();

    public String[] getMessages();

    public boolean isDiscarded();

    public boolean hasRawData();

    public byte[] getRawRequestData();

    public byte[] getRawResponseData();

    public Attachment[] getRequestAttachmentsForPart(String partName);

    public Attachment[] getResponseAttachmentsForPart(String partName);

    public boolean hasRequest(boolean ignoreEmpty);

    public boolean hasResponse();

    public Response getResponse();

    public String getProperty(String name);
}
