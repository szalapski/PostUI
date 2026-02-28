

package com.eviware.soapui.impl.wsdl;

import com.eviware.soapui.model.iface.Attachment;
import com.eviware.soapui.model.iface.MessagePart;
import org.apache.xmlbeans.SchemaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Descriptor for attachments
 *
 * @author Ole.Matzura
 */

public final class HttpAttachmentPart extends MessagePart.AttachmentPart {
    public static final String ANONYMOUS_NAME = "<anonymous>";
    private String name;
    private List<String> contentTypes = new ArrayList<>();
    private Attachment.AttachmentType type;
    private boolean anonymous;
    private SchemaType schemaType;

    public HttpAttachmentPart() {
        anonymous = true;
        name = ANONYMOUS_NAME;
        type = Attachment.AttachmentType.UNKNOWN;
    }

    public HttpAttachmentPart(String name, List<String> types) {
        super();
        this.name = name;

        if (types != null) {
            contentTypes.addAll(types);
        }
    }

    public HttpAttachmentPart(String name, String type) {
        this.name = name;
        if (type != null) {
            contentTypes.add(type);
        }
    }

    public String[] getContentTypes() {
        return contentTypes.toArray(new String[contentTypes.size()]);
    }

    public String getName() {
        return name;
    }

    public void addContentType(String contentType) {
        contentTypes.add(contentType);
    }

    public Attachment.AttachmentType getAttachmentType() {
        return type;
    }

    public void setType(Attachment.AttachmentType type) {
        this.type = type;
    }

    public String getDescription() {
        return name + " attachment; [" + Arrays.toString(getContentTypes()) + "]";
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public SchemaType getSchemaType() {
        return schemaType;
    }

    public void setSchemaType(SchemaType schemaType) {
        this.schemaType = schemaType;
    }
}
