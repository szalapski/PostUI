

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.iface.SoapUIListener;

public interface ProjectRunListener extends SoapUIListener {
    void afterTestSuite(ProjectRunner projectRunner, ProjectRunContext runContext, TestSuiteRunner testRunner);

    void beforeTestSuite(ProjectRunner projectRunner, ProjectRunContext runContext, TestSuite testSuite);

    void beforeRun(ProjectRunner projectRunner, ProjectRunContext runContext);

    void afterRun(ProjectRunner projectRunner, ProjectRunContext runContext);
}
