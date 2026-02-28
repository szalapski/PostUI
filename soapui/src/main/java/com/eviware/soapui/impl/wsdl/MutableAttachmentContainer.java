

package com.eviware.soapui.impl.wsdl;

import com.eviware.soapui.model.iface.Attachment;

import java.io.File;
import java.io.IOException;

/**
 * Behaviour for ModelItems that contain attachments (Requests and
 * MockResponses)
 *
 * @author ole.matzura
 */

public interface MutableAttachmentContainer extends AttachmentContainer {
    public Attachment attachFile(File file, boolean cache) throws IOException;

    public void removeAttachment(Attachment attachment);
}
