

package com.eviware.soapui.impl.wsdl.actions.testsuite;

import com.eviware.soapui.analytics.Analytics;
import com.eviware.soapui.analytics.SoapUIActions;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Adds a new WsdlTestCase to a WsdlTestSuite
 *
 * @author Ole.Matzura
 */

public class AddNewTestCaseAction extends AbstractSoapUIAction<WsdlTestSuite> {
    public static final String SOAPUI_ACTION_ID = "AddNewTestCaseAction";

    public AddNewTestCaseAction() {
        super("New TestCase", "Creates a new TestCase in this TestSuite");
        // putValue( Action.ACCELERATOR_KEY, UISupport.getKeyStroke( "menu N" ));
    }

    public void perform(WsdlTestSuite testSuite, Object param) {
        String name = UISupport.prompt("Specify name of TestCase", "New TestCase",
                "TestCase " + (testSuite.getTestCaseCount() + 1));
        if (name == null) {
            return;
        }
        while (testSuite.getTestCaseByName(name.trim()) != null) {
            name = UISupport.prompt("Specify unique name of TestCase", "Rename TestCase", name);
            if (StringUtils.isNullOrEmpty(name)) {
                return;
            }
        }

        WsdlTestCase testCase = testSuite.addNewTestCase(name);
        if (param != null && param instanceof SoapUIActions) {
            Analytics.trackAction(SoapUIActions.CREATE_TEST_CASE_FROM_TEST_TEST_SUITE_PANEL);
        } else {
            Analytics.trackAction(SoapUIActions.CREATE_TEST_CASE);
        }
        UISupport.showDesktopPanel(testCase);
    }
}
