

package com.eviware.soapui.model.testsuite;

public interface RunListener {
    public void beforeRun(TestRunner testRunner, TestRunContext runContext);

    public void afterRun(TestRunner testRunner, TestRunContext runContext);
}
