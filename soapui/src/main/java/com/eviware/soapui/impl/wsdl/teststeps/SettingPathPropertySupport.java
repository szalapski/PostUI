

package com.eviware.soapui.impl.wsdl.teststeps;

import com.eviware.soapui.impl.wsdl.AbstractWsdlModelItem;

import java.lang.reflect.InvocationTargetException;

public class SettingPathPropertySupport extends AbstractPathPropertySupport {
    private final String defaultValue;

    public SettingPathPropertySupport(AbstractWsdlModelItem<?> modelItem, String settingName) {
        this(modelItem, settingName, null);
    }

    public SettingPathPropertySupport(AbstractWsdlModelItem<?> modelItem, String settingName, String defaultValue) {
        super(modelItem, settingName);
        this.defaultValue = defaultValue;
    }

    public void setPropertyValue(String value) throws IllegalAccessException, InvocationTargetException {
        getModelItem().getSettings().setString(getPropertyName(), value);
    }

    public String getPropertyValue() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getModelItem().getSettings().getString(getPropertyName(), defaultValue);
    }
}
