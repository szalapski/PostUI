

package com.eviware.soapui.support.resolver;

import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.resolver.ResolveContext.Resolver;

public class RemoveTestStepResolver implements Resolver {
    private WsdlTestStep testStep;
    private boolean resolve;

    public RemoveTestStepResolver(WsdlTestStep testStep) {
        this.testStep = testStep;
    }

    @Override
    public String toString() {
        return getDescription();
    }

    public String getDescription() {
        return "Remove Test Step";
    }

    public String getResolvedPath() {
        return null;
    }

    public boolean isResolved() {
        return resolve;
    }

    public boolean resolve() {
        if (UISupport.confirm("Are you sure to remove this test step?", "Remove Test Step")) {
            if (testStep != null) {
                testStep.getTestCase().removeTestStep(testStep);
                resolve = true;
            }
        }
        return resolve;
    }

}
