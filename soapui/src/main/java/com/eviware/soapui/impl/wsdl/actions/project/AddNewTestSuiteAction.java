

package com.eviware.soapui.impl.wsdl.actions.project;

import com.eviware.soapui.analytics.Analytics;
import com.eviware.soapui.analytics.SoapUIActions;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Action for adding a new WsdlTestSuite to a WsdlProject
 *
 * @author Ole.Matzura
 */

public class AddNewTestSuiteAction extends AbstractSoapUIAction<WsdlProject> {
    public static final String SOAPUI_ACTION_ID = "AddNewTestSuiteAction";

    public AddNewTestSuiteAction() {
        super("New TestSuite", "Creates a new TestSuite in this project");
    }

    public void perform(WsdlProject target, Object param) {
        createTestSuite(target);
        if (param != null && param instanceof SoapUIActions) {
            Analytics.trackAction((SoapUIActions) param);
        } else {
            Analytics.trackAction(SoapUIActions.CREATE_TEST_SUITE);
        }
    }

    public WsdlTestSuite createTestSuite(WsdlProject project) {
        String name = UISupport.prompt("Specify name of TestSuite", "New TestSuite",
                "TestSuite " + (project.getTestSuiteCount() + 1));
        if (name == null) {
            return null;
        }
        while (project.getTestSuiteByName(name.trim()) != null) {
            name = UISupport.prompt("Specify unique name of TestSuite", "Rename TestSuite", name);
        }

        WsdlTestSuite testSuite = project.addNewTestSuite(name);
        UISupport.showDesktopPanel(testSuite);
        return testSuite;
    }
}
