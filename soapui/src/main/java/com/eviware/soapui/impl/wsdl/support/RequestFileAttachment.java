

package com.eviware.soapui.impl.wsdl.support;

import com.eviware.soapui.config.AttachmentConfig;
import com.eviware.soapui.impl.support.AbstractHttpRequest;
import com.eviware.soapui.impl.support.AbstractHttpRequestInterface;
import com.eviware.soapui.impl.wsdl.WsdlAttachmentContainer;

import java.io.File;
import java.io.IOException;

/**
 * Attachment for a WsdlRequest
 *
 * @author ole.matzura
 */

public class RequestFileAttachment extends FileAttachment<AbstractHttpRequest<?>> {
    public RequestFileAttachment(AttachmentConfig config, AbstractHttpRequestInterface<?> request) {
        super((AbstractHttpRequest<?>) request, config);
    }

    public RequestFileAttachment(File file, boolean cache, AbstractHttpRequest<?> request) throws IOException {
        super(request, file, cache, request.getConfig().addNewAttachment());
    }

    public AttachmentEncoding getEncoding() {
        AbstractHttpRequestInterface<?> request = getModelItem();
        if (request instanceof WsdlAttachmentContainer && ((WsdlAttachmentContainer) request).isEncodeAttachments()) {
            return ((WsdlAttachmentContainer) request).getAttachmentEncoding(getPart());
        } else {
            return AttachmentEncoding.NONE;
        }
    }

    @Override
    public AttachmentType getAttachmentType() {
        if (getModelItem() == null || getPart() == null || getModelItem().getAttachmentPart(getPart()) == null) {
            return AttachmentType.UNKNOWN;
        } else {
            return getModelItem().getAttachmentPart(getPart()).getAttachmentType();
        }
    }

    public String toString() {
        return getName();
    }

    @Override
    public String getId() {
        return getConfig().getId();
    }
}
