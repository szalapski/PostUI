

package com.eviware.soapui.model;

import com.eviware.soapui.model.testsuite.TestProperty;
import com.eviware.soapui.model.testsuite.TestPropertyListener;

import java.util.List;
import java.util.Map;

public interface TestPropertyHolder {
    public String[] getPropertyNames();

    public void setPropertyValue(String name, String value);

    public String getPropertyValue(String name);

    public TestProperty getProperty(String name);

    public Map<String, TestProperty> getProperties();

    public void addTestPropertyListener(TestPropertyListener listener);

    public void removeTestPropertyListener(TestPropertyListener listener);

    public boolean hasProperty(String name);

    public ModelItem getModelItem();

    public int getPropertyCount();

    public List<TestProperty> getPropertyList();

    public TestProperty getPropertyAt(int index);

    public String getPropertiesLabel();
}
