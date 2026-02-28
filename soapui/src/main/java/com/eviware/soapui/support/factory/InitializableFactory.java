

package com.eviware.soapui.support.factory;

import com.eviware.soapui.config.SoapUIFactoryConfig;

public interface InitializableFactory {
    public void init(SoapUIFactoryConfig factoryConfig);
}
