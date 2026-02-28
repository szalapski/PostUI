

package com.eviware.soapui.model.propertyexpansion;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.types.StringToObjectMap;

public interface PropertyExpansionContext {
    public Object getProperty(String name);

    public void setProperty(String name, Object value);

    public boolean hasProperty(String name);

    public Object removeProperty(String name);

    public String[] getPropertyNames();

    public ModelItem getModelItem();

    public String expand(String content);

    public StringToObjectMap getProperties();
}
