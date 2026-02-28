

package com.eviware.soapui.impl.wsdl.support;

import com.eviware.soapui.config.AttachmentConfig;
import com.eviware.soapui.impl.wsdl.mock.WsdlMockResponse;

import java.io.File;
import java.io.IOException;

/**
 * Attachment for a WsdlMockResponse
 *
 * @author Ole.Matzura
 */

public class MockFileAttachment extends FileAttachment<WsdlMockResponse> {
    public MockFileAttachment(AttachmentConfig config, WsdlMockResponse mockResponse) {
        super(mockResponse, config);
    }

    public MockFileAttachment(File file, boolean cache, WsdlMockResponse response) throws IOException {
        super(response, file, cache, response.getConfig().addNewAttachment());
    }

    @Override
    public AttachmentType getAttachmentType() {
        if (getPart() == null || getModelItem().getAttachmentPart(getPart()) == null) {
            return AttachmentType.UNKNOWN;
        } else {
            return getModelItem().getAttachmentPart(getPart()).getAttachmentType();
        }
    }

    public AttachmentEncoding getEncoding() {
        if (getModelItem().isEncodeAttachments()) {
            return getModelItem().getAttachmentEncoding(getPart());
        } else {
            return AttachmentEncoding.NONE;
        }
    }

    @Override
    public String getId() {
        return null;
    }
}
