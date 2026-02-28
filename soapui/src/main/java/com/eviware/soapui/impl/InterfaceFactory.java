

package com.eviware.soapui.impl;

import com.eviware.soapui.config.InterfaceConfig;
import com.eviware.soapui.impl.support.AbstractInterface;
import com.eviware.soapui.impl.wsdl.WsdlProject;

public interface InterfaceFactory<T extends AbstractInterface<?>> {
    public T createNew(WsdlProject project, String name);

    public T build(WsdlProject project, InterfaceConfig config);
}
