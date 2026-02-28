

package com.eviware.soapui.impl.wsdl.support;

import java.io.File;

public abstract class AbstractExternalDependency implements ExternalDependency {
    private final String path;

    public AbstractExternalDependency(String path) {
        this.path = path;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public Type getType() {
        File file = new File(path);
        if (file.exists()) {
            return file.isDirectory() ? Type.FOLDER : Type.FILE;
        }

        return Type.UNKNOWN;
    }
}
