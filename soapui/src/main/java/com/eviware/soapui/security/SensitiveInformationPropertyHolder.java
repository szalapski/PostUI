

package com.eviware.soapui.security;

import com.eviware.soapui.impl.wsdl.MutableTestPropertyHolder;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.testsuite.TestProperty;
import com.eviware.soapui.model.testsuite.TestPropertyListener;
import org.apache.xmlbeans.SchemaType;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensitiveInformationPropertyHolder implements MutableTestPropertyHolder {

    private Map<String, TestProperty> properties = new HashMap<>();

    @Override
    public void addTestPropertyListener(TestPropertyListener listener) {
        // TODO Auto-generated method stub

    }

    @Override
    public ModelItem getModelItem() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, TestProperty> getProperties() {
        return properties;
    }

    @Override
    public String getPropertiesLabel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TestProperty getProperty(String name) {
        return properties.get(name);
    }

    @Override
    public TestProperty getPropertyAt(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getPropertyCount() {
        // TODO Auto-generated method stub
        return properties.size();
    }

    @Override
    public List<TestProperty> getPropertyList() {
        return new ArrayList<>(properties.values());
    }

    @Override
    public String[] getPropertyNames() {
        return properties.keySet().toArray(new String[properties.keySet().size()]);
    }

    @Override
    public String getPropertyValue(String name) {
        return properties.get(name).getValue();
    }

    @Override
    public boolean hasProperty(String name) {
        return properties.containsKey(name);
    }

    @Override
    public void removeTestPropertyListener(TestPropertyListener listener) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setPropertyValue(String name, String value) {
        if (properties.get(name) != null) {
            properties.get(name).setValue(value);
        } else {
            properties.put(name, new SensitiveTokenProperty(name, value));
        }
    }

    @Override
    public TestProperty addProperty(String name) {
        return properties.put(name, new SensitiveTokenProperty(name, null));
    }

    @Override
    public void moveProperty(String propertyName, int targetIndex) {
        // TODO Auto-generated method stub
    }

    @Override
    public TestProperty removeProperty(String propertyName) {
        return properties.remove(propertyName);
    }

    @Override
    public boolean renameProperty(String name, String newName) {
        TestProperty tp = properties.get(name);
        if (tp != null) {
            properties.put(newName, tp);
            properties.remove(name);
            return true;
        } else {
            return false;
        }
    }

    public class SensitiveTokenProperty implements TestProperty {

        private String name;
        private String value;

        public SensitiveTokenProperty(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getDefaultValue() {
            return "";
        }

        @Override
        public String getDescription() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public ModelItem getModelItem() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public SchemaType getSchemaType() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public QName getType() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public boolean isReadOnly() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isRequestPart() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void setValue(String value) {
            this.value = value;
        }

        public void setName(String aValue) {
            this.name = aValue;
        }

    }

}
