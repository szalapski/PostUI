

package com.eviware.soapui.impl.wsdl;

import com.eviware.soapui.model.TestPropertyHolder;
import com.eviware.soapui.model.testsuite.TestProperty;

public interface MutableTestPropertyHolder extends TestPropertyHolder {
    public TestProperty addProperty(String name);

    public TestProperty removeProperty(String propertyName);

    public boolean renameProperty(String name, String newName);

    public void moveProperty(String propertyName, int targetIndex);
}
