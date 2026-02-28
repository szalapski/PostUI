

package com.eviware.soapui.model.propertyexpansion.resolvers;

import com.eviware.soapui.impl.support.AbstractHttpRequest;
import com.eviware.soapui.impl.support.AbstractHttpRequestInterface;
import com.eviware.soapui.model.propertyexpansion.PropertyExpansion;
import com.eviware.soapui.model.propertyexpansion.PropertyExpansionContext;

public class SubmitPropertyResolver implements PropertyResolver {
    public String resolveProperty(PropertyExpansionContext context, String propertyName, boolean globalOverride) {
        if (propertyName.charAt(0) == PropertyExpansion.SCOPE_PREFIX
                && context.getModelItem() instanceof AbstractHttpRequestInterface<?>) {
            return ResolverUtils.checkForExplicitReference(propertyName, PropertyExpansion.PROJECT_REFERENCE,
                    ((AbstractHttpRequest<?>) context.getModelItem()).getOperation().getInterface().getProject(),
                    context, globalOverride);
        }

        return null;
    }

}
