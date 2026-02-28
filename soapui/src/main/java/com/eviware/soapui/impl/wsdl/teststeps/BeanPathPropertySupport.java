

package com.eviware.soapui.impl.wsdl.teststeps;

import com.eviware.soapui.impl.wsdl.AbstractWsdlModelItem;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class BeanPathPropertySupport extends AbstractPathPropertySupport {
    private Object config;

    public BeanPathPropertySupport(AbstractWsdlModelItem<?> modelItem, String propertyName) {
        this(modelItem, modelItem.getConfig(), propertyName);
    }

    public BeanPathPropertySupport(AbstractWsdlModelItem<?> modelItem, Object config, String propertyName) {
        super(modelItem, propertyName);
        this.config = config;
    }

    public void setPropertyValue(String value) throws IllegalAccessException, InvocationTargetException {
        BeanUtils.setProperty(config, getPropertyName(), value);
    }

    public String getPropertyValue() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return BeanUtils.getProperty(config, getPropertyName());
    }

    public void setConfig(Object config) {
        this.config = config;
    }
}
