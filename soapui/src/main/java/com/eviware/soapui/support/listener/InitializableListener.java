

package com.eviware.soapui.support.listener;

import com.eviware.soapui.config.SoapUIListenerConfig;

public interface InitializableListener {
    public void init(SoapUIListenerConfig listenerConfig);
}
