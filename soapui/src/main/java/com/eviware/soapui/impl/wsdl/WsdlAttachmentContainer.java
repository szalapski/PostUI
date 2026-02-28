

package com.eviware.soapui.impl.wsdl;

import com.eviware.soapui.model.iface.Attachment.AttachmentEncoding;

public interface WsdlAttachmentContainer extends AttachmentContainer {
    /**
     * If Message Transmission Optimization Mechanism is enabled or not
     */
    public boolean isMtomEnabled();

    public boolean isInlineFilesEnabled();

    public boolean isEncodeAttachments();

    AttachmentEncoding getAttachmentEncoding(String partName);
}
