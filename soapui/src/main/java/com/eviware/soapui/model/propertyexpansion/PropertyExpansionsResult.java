

package com.eviware.soapui.model.propertyexpansion;

import com.eviware.soapui.model.ModelItem;

import java.util.ArrayList;

public class PropertyExpansionsResult extends ArrayList<PropertyExpansion> {
    private final ModelItem modelItem;
    private final Object defaultTarget;

    public PropertyExpansionsResult(ModelItem modelItem) {
        this(modelItem, modelItem);
    }

    public PropertyExpansionsResult(ModelItem modelItem, Object defaultTarget) {
        this.modelItem = modelItem;
        this.defaultTarget = defaultTarget;
    }

    public boolean extractAndAddAll(Object target, String propertyName) {
        return addAll(PropertyExpansionUtils.extractPropertyExpansions(modelItem, target, propertyName));
    }

    public boolean extractAndAddAll(String propertyName) {
        return addAll(PropertyExpansionUtils.extractPropertyExpansions(modelItem, defaultTarget, propertyName));
    }

    public PropertyExpansion[] toArray() {
        return toArray(new PropertyExpansion[size()]);
    }

    public void addAll(PropertyExpansion[] propertyExpansions) {
        if (propertyExpansions == null) {
            return;
        }

        for (PropertyExpansion pe : propertyExpansions) {
            add(pe);
        }
    }
}
