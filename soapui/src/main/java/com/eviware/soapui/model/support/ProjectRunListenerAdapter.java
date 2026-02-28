

package com.eviware.soapui.model.support;

import com.eviware.soapui.model.testsuite.ProjectRunContext;
import com.eviware.soapui.model.testsuite.ProjectRunListener;
import com.eviware.soapui.model.testsuite.ProjectRunner;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.model.testsuite.TestSuiteRunner;

public class ProjectRunListenerAdapter implements ProjectRunListener {
    public void afterRun(ProjectRunner projectRunner, ProjectRunContext runContext) {
    }

    public void afterTestSuite(ProjectRunner projectRunner, ProjectRunContext runContext, TestSuiteRunner testRunner) {
    }

    public void beforeRun(ProjectRunner projectRunner, ProjectRunContext runContext) {
    }

    public void beforeTestSuite(ProjectRunner projectRunner, ProjectRunContext runContext, TestSuite testRunnable) {
    }
}
