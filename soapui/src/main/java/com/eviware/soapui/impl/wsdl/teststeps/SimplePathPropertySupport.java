

package com.eviware.soapui.impl.wsdl.teststeps;

import com.eviware.soapui.impl.wsdl.AbstractWsdlModelItem;

public class SimplePathPropertySupport extends AbstractPathPropertySupport {
    private String value;

    public SimplePathPropertySupport(AbstractWsdlModelItem<?> modelItem) {
        super(modelItem, null);
    }

    public void setPropertyValue(String value) {
        this.value = value;
    }

    public String getPropertyValue() {
        return value;
    }

    public void set(String value) {
        super.set(value, false);
    }
}
