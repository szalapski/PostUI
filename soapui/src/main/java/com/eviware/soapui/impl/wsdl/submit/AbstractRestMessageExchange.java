

package com.eviware.soapui.impl.wsdl.submit;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.iface.Attachment;

import java.util.ArrayList;
import java.util.List;

/**
 * MessageExchange for WSDL-based exchanges
 *
 * @author ole.matzura
 */

public abstract class AbstractRestMessageExchange<T extends ModelItem> extends AbstractMessageExchange<T> implements
        RestMessageExchange {
    public AbstractRestMessageExchange(T modelItem) {
        super(modelItem);
    }

    public boolean hasResponse() {
        String responseContent = getResponseContent();
        return responseContent != null && responseContent.trim().length() > 0;
    }

    public Attachment[] getResponseAttachmentsForPart(String name) {
        List<Attachment> result = new ArrayList<>();

        if (getResponseAttachments() != null) {
            for (Attachment attachment : getResponseAttachments()) {
                if (attachment.getPart().equals(name)) {
                    result.add(attachment);
                }
            }
        }

        return result.toArray(new Attachment[result.size()]);
    }

    public Attachment[] getRequestAttachmentsForPart(String name) {
        List<Attachment> result = new ArrayList<>();

        for (Attachment attachment : getRequestAttachments()) {
            if (attachment.getPart().equals(name)) {
                result.add(attachment);
            }
        }

        return result.toArray(new Attachment[result.size()]);
    }

    public boolean hasRequest(boolean ignoreEmpty) {
        String requestContent = getRequestContent();
        return !(requestContent == null || (ignoreEmpty && requestContent.trim().length() == 0));
    }

    public boolean hasRawData() {
        return false;
    }

    public byte[] getRawRequestData() {
        return null;
    }

    public byte[] getRawResponseData() {
        return null;
    }
}
