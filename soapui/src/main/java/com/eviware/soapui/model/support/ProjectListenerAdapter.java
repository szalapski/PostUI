

package com.eviware.soapui.model.support;

import com.eviware.soapui.model.environment.Environment;
import com.eviware.soapui.model.iface.Interface;
import com.eviware.soapui.model.mock.MockService;
import com.eviware.soapui.model.project.Project;
import com.eviware.soapui.model.project.ProjectListener;
import com.eviware.soapui.model.testsuite.TestSuite;

/**
 * Adapter for ProjectListener implementations
 *
 * @author Ole.Matzura
 */

public class ProjectListenerAdapter implements ProjectListener {
    public void interfaceAdded(Interface iface) {
    }

    public void interfaceRemoved(Interface iface) {
    }

    public void testSuiteAdded(TestSuite testSuite) {
    }

    public void testSuiteRemoved(TestSuite testSuite) {
    }

    public void testSuiteMoved(TestSuite testSuite, int index, int offset) {

    }

    public void mockServiceAdded(MockService mockService) {
    }

    public void mockServiceRemoved(MockService mockService) {
    }

    public void interfaceUpdated(Interface iface) {
    }

    public void afterLoad(Project project) {
    }

    public void beforeSave(Project project) {
    }

    public void environmentAdded(Environment env) {
    }

    public void environmentRemoved(Environment env, int index) {
    }

    public void environmentSwitched(Environment environment) {
    }

    @Override
    public void environmentRenamed(Environment environment, String oldName, String newName) {
        // TODO Auto-generated method stub

    }
}
