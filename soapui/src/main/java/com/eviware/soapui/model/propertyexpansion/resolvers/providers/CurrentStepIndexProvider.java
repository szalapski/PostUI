

package com.eviware.soapui.model.propertyexpansion.resolvers.providers;

import com.eviware.soapui.model.propertyexpansion.PropertyExpansionContext;
import com.eviware.soapui.model.propertyexpansion.resolvers.DynamicPropertyResolver;
import com.eviware.soapui.model.testsuite.TestCaseRunContext;

/**
 * Returns the current teststep index
 */

public class CurrentStepIndexProvider implements DynamicPropertyResolver.ValueProvider {
    @Override
    public String getValue(PropertyExpansionContext context) {
        if( context instanceof TestCaseRunContext )
        {
            return String.valueOf( ((TestCaseRunContext)context).getCurrentStepIndex());
        }

        return null;
    }
}
