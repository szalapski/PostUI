

package com.eviware.soapui.impl.wsdl;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.iface.Attachment;
import com.eviware.soapui.model.iface.MessagePart.AttachmentPart;

import java.beans.PropertyChangeListener;

/**
 * Behaviour for ModelItems that contain attachments (Requests and
 * MockResponses)
 *
 * @author ole.matzura
 */

public interface AttachmentContainer {
    public int getAttachmentCount();

    public Attachment getAttachmentAt(int index);

    public Attachment[] getAttachmentsForPart(String partName);

    public Attachment[] getAttachments();

    public AttachmentPart[] getDefinedAttachmentParts();

    public AttachmentPart getAttachmentPart(String partName);

    public static final String ATTACHMENTS_PROPERTY = WsdlRequest.class.getName() + "@attachments";

    public void addAttachmentsChangeListener(PropertyChangeListener listener);

    public void removeAttachmentsChangeListener(PropertyChangeListener listener);

    public boolean isMultipartEnabled();

    /**
     * Returns ModelItem associated with this container
     */

    public ModelItem getModelItem();
}
