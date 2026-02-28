

package com.eviware.soapui.impl.wsdl.support;

import com.eviware.soapui.config.AttachmentConfig;
import com.eviware.soapui.model.iface.Attachment;
import org.apache.xmlbeans.XmlObject;

import java.io.File;
import java.io.IOException;

/**
 * WSDL-specific Attachment behaviour
 *
 * @author ole.matzura
 */

public interface WsdlAttachment extends Attachment {
    public void updateConfig(AttachmentConfig config);

    public XmlObject getConfig();

    public void setContentID(String contentID);

    public void reload(File file, boolean cache) throws IOException;

    public void setName(String value);

    public void setUrl(String string);
}
