

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.project.Project;

import java.util.List;

public interface ProjectRunner extends TestRunner {
    public Project getProject();

    public List<TestSuiteRunner> getResults();
}
