

package com.eviware.soapui.model.propertyexpansion;

import com.eviware.soapui.model.testsuite.TestProperty;
import org.apache.commons.beanutils.PropertyUtils;

public class MutablePropertyExpansionImpl extends PropertyExpansionImpl implements MutablePropertyExpansion {
    private final Object container;
    private final String propertyName;
    private String stringRep;

    public MutablePropertyExpansionImpl(TestProperty tp, String xpath, Object container, String propertyName) {
        super(tp, xpath);
        this.container = container;
        this.propertyName = propertyName;

        stringRep = toString();
    }

    public void setProperty(TestProperty property) {
        super.setProperty(property);
    }

    public void setXPath(String xpath) {
        super.setXPath(xpath);
    }

    public void update() throws Exception {
        String rep = toString();

        // not changed
        if (stringRep.equals(rep)) {
            return;
        }

        Object obj = PropertyUtils.getProperty(container, propertyName);
        if (obj == null) {
            throw new Exception("property value is null");
        }

        String str = obj.toString();
        int ix = str.indexOf(stringRep);
        if (ix == -1) {
            throw new Exception("property expansion [" + stringRep + "] not found for update");
        }

        while (ix != -1) {
            str = str.substring(0, ix) + rep + str.substring(ix + stringRep.length());
            ix = str.indexOf(stringRep, ix + rep.length());
        }

        PropertyUtils.setProperty(container, propertyName, str);

        stringRep = rep;
    }
}
