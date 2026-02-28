

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.project.Project;

/**
 * Context information for a testcase run session
 */

public interface ProjectRunContext extends TestRunContext {
    public ProjectRunner getProjectRunner();

    public Project getProject();
}
