

package com.eviware.soapui.impl.support.definition.support;

import com.eviware.soapui.config.DefinitionCacheConfig;
import com.eviware.soapui.impl.support.AbstractInterface;

public class StandaloneDefinitionCache<T extends AbstractInterface<?>> extends AbstractDefinitionCache<T> {
    public StandaloneDefinitionCache() {
        super(DefinitionCacheConfig.Factory.newInstance(), null);
    }

    protected DefinitionCacheConfig reinit(T owner) {
        return DefinitionCacheConfig.Factory.newInstance();
    }
}
