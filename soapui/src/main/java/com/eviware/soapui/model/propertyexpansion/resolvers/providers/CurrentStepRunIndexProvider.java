

package com.eviware.soapui.model.propertyexpansion.resolvers.providers;

import com.eviware.soapui.impl.wsdl.support.AbstractTestCaseRunner;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestRunContext;
import com.eviware.soapui.model.propertyexpansion.PropertyExpansionContext;
import com.eviware.soapui.model.propertyexpansion.resolvers.DynamicPropertyResolver;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.model.testsuite.TestStepResult;

import java.util.List;

/**
 * Returns the current teststep index
 */

public class CurrentStepRunIndexProvider implements DynamicPropertyResolver.ValueProvider {
    @Override
    public String getValue(PropertyExpansionContext context) {
        if( context instanceof WsdlTestRunContext)
        {
            TestRunner runner = ((WsdlTestRunContext) context).getTestRunner();
            if( runner instanceof AbstractTestCaseRunner) {
                List<TestStepResult> resultList = ((AbstractTestCaseRunner) runner).getResults();
                TestStep currentStep = ((WsdlTestRunContext) context).getCurrentStep();

                int ix = 0;
                for( TestStepResult result : resultList )
                    if( result.getTestStep().getId().equals( currentStep.getId()))
                        ix++;

                return String.valueOf( ix );
            }
        }

        return null;
    }
}
