

package com.eviware.soapui.support.registry;

import com.eviware.soapui.config.RegistryEntryConfig;

public interface RegistryEntry<T1 extends RegistryEntryConfig, T2 extends Object> {
    public void init(T1 config, T2 container);
}
