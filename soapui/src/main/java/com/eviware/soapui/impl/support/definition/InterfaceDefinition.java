

package com.eviware.soapui.impl.support.definition;

import com.eviware.soapui.model.iface.Interface;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;

import javax.xml.namespace.QName;
import java.util.Collection;

public interface InterfaceDefinition<T extends Interface> {
    public String getTargetNamespace();

    public SchemaTypeLoader getSchemaTypeLoader();

    public SchemaTypeSystem getSchemaTypeSystem();

    public boolean hasSchemaTypes();

    public Collection<String> getDefinedNamespaces() throws Exception;

    public SchemaType findType(QName name);

    public DefinitionCache getDefinitionCache();

    public T getInterface();
}
