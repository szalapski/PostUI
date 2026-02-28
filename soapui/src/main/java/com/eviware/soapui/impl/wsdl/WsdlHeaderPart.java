

package com.eviware.soapui.impl.wsdl;

import com.eviware.soapui.model.iface.MessagePart;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaType;

import javax.xml.namespace.QName;

/**
 * Descriptor for a Message/SOAP Header
 *
 * @author ole.matzura
 */

public class WsdlHeaderPart extends MessagePart.HeaderPart {
    private String name;
    private SchemaType schemaType;
    private QName partElementName;
    private final SchemaGlobalElement partElement;

    public WsdlHeaderPart(String name, SchemaType schemaType, QName partElementName, SchemaGlobalElement partElement) {
        super();

        this.name = name;
        this.schemaType = schemaType;
        this.partElementName = partElementName;
        this.partElement = partElement;
    }

    public SchemaType getSchemaType() {
        return schemaType;
    }

    public String getDescription() {
        return name + " of type [" + schemaType.getName() + "]";
    }

    public String getName() {
        return name;
    }

    public QName getPartElementName() {
        return partElementName;
    }

    @Override
    public SchemaGlobalElement getPartElement() {
        return partElement;
    }
}
