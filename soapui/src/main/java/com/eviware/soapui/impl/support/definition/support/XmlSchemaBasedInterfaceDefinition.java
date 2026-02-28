

package com.eviware.soapui.impl.support.definition.support;

import com.eviware.soapui.impl.support.AbstractInterface;
import com.eviware.soapui.impl.support.definition.DefinitionLoader;
import com.eviware.soapui.impl.wsdl.support.xsd.SchemaException;
import com.eviware.soapui.impl.wsdl.support.xsd.SchemaUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;

import javax.xml.namespace.QName;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class XmlSchemaBasedInterfaceDefinition<T extends AbstractInterface<?>> extends
        AbstractInterfaceDefinition<T> {
    private SchemaTypeSystem schemaTypes;
    private SchemaTypeLoader schemaTypeLoader;

    public XmlSchemaBasedInterfaceDefinition(T iface) {
        super(iface);
    }

    public SchemaTypeLoader getSchemaTypeLoader() {
        return schemaTypeLoader;
    }

    public SchemaTypeSystem getSchemaTypeSystem() {
        return schemaTypes;
    }

    public boolean hasSchemaTypes() {
        return schemaTypes != null;
    }

    public Collection<String> getDefinedNamespaces() throws Exception {
        Set<String> namespaces = new HashSet<>();

        SchemaTypeSystem schemaTypes = getSchemaTypeSystem();
        if (schemaTypes != null) {
            namespaces.addAll(SchemaUtils.extractNamespaces(getSchemaTypeSystem(), true));
        }

        namespaces.add(getTargetNamespace());

        return namespaces;
    }

    public SchemaType findType(QName typeName) {
        return getSchemaTypeLoader().findType(typeName);
    }

    public void loadSchemaTypes(DefinitionLoader loader) throws SchemaException {
        schemaTypes = SchemaUtils.loadSchemaTypes(loader.getBaseURI(), loader);
        schemaTypeLoader = XmlBeans.typeLoaderUnion(new SchemaTypeLoader[]{schemaTypes,
                XmlBeans.getBuiltinTypeSystem()});
    }
}
