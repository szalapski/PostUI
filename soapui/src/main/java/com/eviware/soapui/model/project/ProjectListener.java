

package com.eviware.soapui.model.project;

import com.eviware.soapui.model.environment.Environment;
import com.eviware.soapui.model.iface.Interface;
import com.eviware.soapui.model.iface.SoapUIListener;
import com.eviware.soapui.model.mock.MockService;
import com.eviware.soapui.model.testsuite.TestSuite;

/**
 * Listener for Project-related events
 *
 * @author Ole.Matzura
 */

public interface ProjectListener extends SoapUIListener {
    void interfaceAdded(Interface iface);

    void interfaceRemoved(Interface iface);

    void interfaceUpdated(Interface iface);

    void testSuiteAdded(TestSuite testSuite);

    void testSuiteRemoved(TestSuite testSuite);

    void testSuiteMoved(TestSuite testSuite, int index, int offset);

    void mockServiceAdded(MockService mockService);

    void mockServiceRemoved(MockService mockService);

    void afterLoad(Project project);

    void beforeSave(Project project);

    void environmentAdded(Environment env);

    void environmentRemoved(Environment env, int index);

    void environmentSwitched(Environment environment);

    void environmentRenamed(Environment environment, String oldName, String newName);
}
