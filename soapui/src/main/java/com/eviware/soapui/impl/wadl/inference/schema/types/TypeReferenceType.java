

package com.eviware.soapui.impl.wadl.inference.schema.types;

import com.eviware.soapui.impl.wadl.inference.schema.Context;
import com.eviware.soapui.impl.wadl.inference.schema.Schema;
import com.eviware.soapui.impl.wadl.inference.schema.SchemaSystem;
import com.eviware.soapui.impl.wadl.inference.schema.Type;
import com.eviware.soapui.inferredSchema.TypeConfig;
import com.eviware.soapui.inferredSchema.TypeReferenceConfig;
import org.apache.xmlbeans.XmlException;

/**
 * This Type is simply a reference to another, actual Type. It is used when
 * loading previously saved data, since the Type may not yet be loaded.
 *
 * @author Dain Nilsson
 */
public class TypeReferenceType implements Type {
    String name;
    String namespace;
    SchemaSystem schemaSystem;

    /**
     * Constructs a new TypeReferenceType from previously saved data. Should be
     * called in the Type.Factory.
     */
    public TypeReferenceType(TypeReferenceConfig xml, Schema schema) {
        schemaSystem = schema.getSystem();
        name = xml.getReference().getLocalPart();
        namespace = xml.getReference().getNamespaceURI();
    }

    public TypeConfig save() {
        return schemaSystem.getSchemaForNamespace(namespace).getType(name).save();
    }

    public String getName() {
        return name;
    }

    public Type validate(Context context) throws XmlException {
        return schemaSystem.getSchemaForNamespace(namespace).getType(name);
    }

    public Schema getSchema() {
        return schemaSystem.getSchemaForNamespace(namespace);
    }

    public void setSchema(Schema schema) {
        namespace = schema.getNamespace();
    }

}
