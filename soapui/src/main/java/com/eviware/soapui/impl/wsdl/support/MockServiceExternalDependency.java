

package com.eviware.soapui.impl.wsdl.support;

import com.eviware.soapui.impl.wsdl.teststeps.AbstractPathPropertySupport;

public class MockServiceExternalDependency extends PathPropertyExternalDependency {

    /**
     * @param pathProperty
     */
    public MockServiceExternalDependency(AbstractPathPropertySupport pathProperty) {
        super(pathProperty);
    }

    /**
     * @param pathProperty
     * @param type
     */
    public MockServiceExternalDependency(AbstractPathPropertySupport pathProperty, Type type) {
        super(pathProperty, type);
    }

}
