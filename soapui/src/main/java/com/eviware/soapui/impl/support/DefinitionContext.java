

package com.eviware.soapui.impl.support;

import com.eviware.soapui.impl.support.definition.InterfaceDefinition;
import com.eviware.soapui.model.iface.Interface;

public interface DefinitionContext<T extends Interface> {
    public boolean hasSchemaTypes();

    public boolean isCached();

    public T getInterface();

    public InterfaceDefinition<T> getInterfaceDefinition() throws Exception;

    public String export(String path) throws Exception;

    public boolean loadIfNecessary() throws Exception;
}
