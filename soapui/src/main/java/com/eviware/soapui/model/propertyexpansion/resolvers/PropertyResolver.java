

package com.eviware.soapui.model.propertyexpansion.resolvers;

import com.eviware.soapui.model.propertyexpansion.PropertyExpansionContext;

public interface PropertyResolver {
    public String resolveProperty(PropertyExpansionContext context, String name, boolean globalOverride);
}
