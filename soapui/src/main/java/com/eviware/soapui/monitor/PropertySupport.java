

package com.eviware.soapui.monitor;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.propertyexpansion.DefaultPropertyExpansionContext;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.util.Properties;

public class PropertySupport {
    public static void applySystemProperties(Object target, String scope, ModelItem modelItem) {
        PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(target);
        DefaultPropertyExpansionContext context = new DefaultPropertyExpansionContext(modelItem);
        Properties properties = System.getProperties();

        for (PropertyDescriptor descriptor : descriptors) {
            String name = descriptor.getName();
            String key = scope + "." + name;
            if (PropertyUtils.isWriteable(target, name) && properties.containsKey(key)) {
                try {
                    String value = context.expand(String.valueOf(properties.get(key)));
                    BeanUtils.setProperty(target, name, value);
                    SoapUI.log.info("Set property [" + name + "] to [" + value + "] in scope [" + scope + "]");
                } catch (Throwable e) {
                    SoapUI.logError(e);
                }
            }
        }
    }

}
