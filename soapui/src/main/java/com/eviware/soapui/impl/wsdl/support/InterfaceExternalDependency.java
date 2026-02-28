

package com.eviware.soapui.impl.wsdl.support;

import com.eviware.soapui.impl.wsdl.teststeps.AbstractPathPropertySupport;

public class InterfaceExternalDependency extends PathPropertyExternalDependency {

    /**
     * @param pathProperty
     */
    public InterfaceExternalDependency(AbstractPathPropertySupport pathProperty) {
        super(pathProperty);
    }

    /**
     * @param pathProperty
     * @param type
     */
    public InterfaceExternalDependency(AbstractPathPropertySupport pathProperty, Type type) {
        super(pathProperty, type);
    }

}
