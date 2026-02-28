

package com.eviware.soapui.impl.wsdl.loadtest;

import com.eviware.soapui.model.propertyexpansion.DefaultPropertyExpansionContext;
import com.eviware.soapui.model.testsuite.LoadTestRunContext;
import com.eviware.soapui.model.testsuite.LoadTestRunner;
import com.eviware.soapui.model.testsuite.TestCaseRunner;

/**
 * LoadTestRunContext implementation for WsdlLoadTests
 *
 * @author Ole.Matzura
 */

public class WsdlLoadTestContext extends DefaultPropertyExpansionContext implements LoadTestRunContext {
    private final LoadTestRunner runner;

    public WsdlLoadTestContext(LoadTestRunner runner) {
        super(runner.getLoadTest().getTestCase());
        this.runner = runner;
    }

    public LoadTestRunner getLoadTestRunner() {
        return runner;
    }

    @Override
    public Object get(Object key) {
        if ("loadTestRunner".equals(key)) {
            return runner;
        }

        return super.get(key);
    }

    public Object getProperty(String testStep, String propertyName) {
        return null;
    }

    public TestCaseRunner getTestRunner() {
        return null;
    }
}
