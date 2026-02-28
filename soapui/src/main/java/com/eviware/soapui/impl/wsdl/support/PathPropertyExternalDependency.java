

package com.eviware.soapui.impl.wsdl.support;

import com.eviware.soapui.impl.wsdl.teststeps.AbstractPathPropertySupport;

public class PathPropertyExternalDependency implements ExternalDependency {
    private final AbstractPathPropertySupport pathProperty;
    private final Type type;

    public PathPropertyExternalDependency(AbstractPathPropertySupport pathProperty) {
        this(pathProperty, Type.FILE);
    }

    public PathPropertyExternalDependency(AbstractPathPropertySupport pathProperty, Type type) {
        this.pathProperty = pathProperty;
        this.type = type;
    }

    @Override
    public String getPath() {
        return pathProperty.expand();
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void updatePath(String path) {
        pathProperty.set(path, true);
    }
}
