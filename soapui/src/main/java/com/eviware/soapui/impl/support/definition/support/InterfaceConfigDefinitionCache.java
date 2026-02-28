

package com.eviware.soapui.impl.support.definition.support;

import com.eviware.soapui.config.DefinitionCacheConfig;
import com.eviware.soapui.config.InterfaceConfig;
import com.eviware.soapui.impl.support.AbstractInterface;

public class InterfaceConfigDefinitionCache<T extends AbstractInterface<?>> extends AbstractDefinitionCache<T> {
    public InterfaceConfigDefinitionCache(T iface) {
        super(iface.getConfig().getDefinitionCache(), iface);
    }

    protected DefinitionCacheConfig reinit(T iface) {
        InterfaceConfig config = iface.getConfig();
        if (config.isSetDefinitionCache()) {
            config.unsetDefinitionCache();
        }

        return config.addNewDefinitionCache();
    }
}
