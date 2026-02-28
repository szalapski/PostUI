

package com.eviware.soapui.model.iface;

import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaType;

import javax.wsdl.Part;
import javax.xml.namespace.QName;

/**
 * A message part in a Request
 *
 * @author ole.matzura
 */

public interface MessagePart {
    public String getName();

    public String getDescription();

    public PartType getPartType();

    public enum PartType {
        HEADER, CONTENT, ATTACHMENT, FAULT, PARAMETER
    }

    ;

    public abstract static class ContentPart implements MessagePart {
        public abstract SchemaType getSchemaType();

        public abstract QName getPartElementName();

        public abstract SchemaGlobalElement getPartElement();

        public PartType getPartType() {
            return PartType.CONTENT;
        }
    }

    public abstract static class AttachmentPart implements MessagePart {
        public abstract String[] getContentTypes();

        public abstract boolean isAnonymous();

        public PartType getPartType() {
            return PartType.ATTACHMENT;
        }
    }

    public abstract static class HeaderPart extends ContentPart {
        public PartType getPartType() {
            return PartType.HEADER;
        }
    }

    public abstract static class ParameterPart extends ContentPart {
        public PartType getPartType() {
            return PartType.PARAMETER;
        }
    }

    public abstract static class FaultPart extends ContentPart {
        public PartType getPartType() {
            return PartType.FAULT;
        }

        public abstract Part[] getWsdlParts();
    }
}
