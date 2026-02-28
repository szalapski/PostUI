

package com.eviware.soapui.impl.wsdl.support;

public interface ExternalDependency {
    public enum Type {
        FILE, FOLDER, UNKNOWN
    }

    ;

    public String getPath();

    public Type getType();

    public void updatePath(String path);
}
