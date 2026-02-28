

package com.eviware.soapui.model.propertyexpansion.resolvers.providers;

import com.eviware.soapui.impl.wsdl.support.AbstractTestCaseRunner;
import com.eviware.soapui.model.propertyexpansion.PropertyExpansionContext;
import com.eviware.soapui.model.propertyexpansion.resolvers.DynamicPropertyResolver;
import com.eviware.soapui.model.testsuite.TestRunContext;
import com.eviware.soapui.model.testsuite.TestRunner;

/**
 * Returns the current teststep index
 */

public class CurrentRunStepIndexProvider implements DynamicPropertyResolver.ValueProvider {
    @Override
    public String getValue(PropertyExpansionContext context) {
        if( context instanceof TestRunContext)
        {
            TestRunner runner = ((TestRunContext) context).getTestRunner();
            if( runner instanceof AbstractTestCaseRunner)
                return String.valueOf(((AbstractTestCaseRunner)runner).getResultCount());
        }

        return null;
    }
}
