

package com.eviware.soapui.model.propertyexpansion;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.types.StringToObjectMap;

public class DefaultPropertyExpansionContext extends StringToObjectMap implements PropertyExpansionContext {
    private ModelItem modelItem;

    public DefaultPropertyExpansionContext(ModelItem modelItem) {
        this.modelItem = modelItem;
    }

    public String expand(String content) {
        return PropertyExpander.expandProperties(this, content);
    }

    public ModelItem getModelItem() {
        return modelItem;
    }

    public Object getProperty(String name) {
        return super.get(name);
    }

    public String[] getPropertyNames() {
        return keySet().toArray(new String[size()]);
    }

    @Override
    public Object get(Object key) {
        Object result = super.get(key);

        if (result == null) {
            result = expand((String) key);
            if (key.equals(result)) {
                result = expand("${" + key + "}");
                if (StringUtils.isNullOrEmpty((String) result)) {
                    result = null;
                }
            }
        }

        return result;
    }

    public boolean hasProperty(String name) {
        return containsKey(name);
    }

    public Object removeProperty(String name) {
        return remove(name);
    }

    public void setProperty(String name, Object value) {
        put(name, value);
    }

    public void setProperties(PropertyExpansionContext context) {
        for (String name : context.getPropertyNames()) {
            setProperty(name, context.getProperty(name));
        }
    }

    public StringToObjectMap getProperties() {
        return this;
    }
}
