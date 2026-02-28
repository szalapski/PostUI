

package com.eviware.soapui.support.propertyexpansion;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.propertyexpansion.PropertyExpansion;

import java.awt.Point;

public interface PropertyExpansionTarget {
    public void insertPropertyExpansion(PropertyExpansion expansion, Point point);

    public ModelItem getContextModelItem();

    public String getValueForCreation();

    public String getNameForCreation();
}
