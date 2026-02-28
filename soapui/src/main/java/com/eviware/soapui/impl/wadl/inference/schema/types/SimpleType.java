

package com.eviware.soapui.impl.wadl.inference.schema.types;

import com.eviware.soapui.impl.wadl.inference.ConflictHandler;
import com.eviware.soapui.impl.wadl.inference.schema.Context;
import com.eviware.soapui.impl.wadl.inference.schema.Schema;
import com.eviware.soapui.impl.wadl.inference.schema.Settings;
import com.eviware.soapui.impl.wadl.inference.schema.Type;
import com.eviware.soapui.impl.wadl.inference.support.TypeInferrer;
import com.eviware.soapui.inferredSchema.SimpleTypeConfig;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;

/**
 * SimpleType corresponds to an instance of a xs:simpleType. Each element or
 * attribute with a value of a specific xs:simpleType should have its own
 * instance of SimpleType.
 *
 * @author Dain Nilsson
 */
public class SimpleType implements Type {
    private XmlAnySimpleType simpleType;
    private Schema schema;
    private boolean completed = true;

    public SimpleType(Schema schema, XmlAnySimpleType simpleType, boolean completed) {
        this.schema = schema;
        this.simpleType = simpleType;
        this.completed = completed;
    }

    public SimpleType(SimpleTypeConfig xml, Schema schema) {
        this.schema = schema;
        completed = xml.getCompleted();
        simpleType = TypeInferrer.getType(xml.getTypeName());
    }

    public SimpleTypeConfig save() {
        SimpleTypeConfig xml = SimpleTypeConfig.Factory.newInstance();
        xml.setCompleted(completed);
        xml.setTypeName(simpleType.schemaType().getName().getLocalPart());
        return xml;
    }

    public Type validate(Context context) throws XmlException {
        XmlCursor cursor = context.getCursor();
        if (!cursor.isAttr() && (cursor.toFirstAttribute() || cursor.toFirstChild())) {
            // Element with complex content
            return new ComplexType(schema, context.getName(), completed);
        } else if (!context.getAttribute("nil").equals("true")) {
            String value = "";
            cursor.toFirstContentToken();
            if (!cursor.isEnd()) {
                value = cursor.getTextValue();
            }
            if (TypeInferrer.validateSimpleType(value, simpleType)) {
                return this;
            }
            XmlAnySimpleType newType = TypeInferrer.expandTypeForValue(value, simpleType);
            if (cursor.getName() == null) {
                cursor.toParent();
            }
            if (context.getHandler().callback(ConflictHandler.Event.MODIFICATION, ConflictHandler.Type.TYPE,
                    cursor.getName(), context.getPath(), "Illegal content '" + value + "'")) {
                // Switch to other simpleType.
                // return
                // context.getSchemaSystem().getType(newType.schemaType().getName());
                simpleType = newType;
            } else {
                throw new XmlException("Invalid value!");
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return "";
    }

    public String getName() {
        return schema.getPrefixForNamespace(Settings.xsdns) + ":" + simpleType.schemaType().getName().getLocalPart();
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

}
