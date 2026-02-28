

package com.eviware.soapui.impl.wsdl.actions.testcase;

import com.eviware.soapui.analytics.Analytics;
import com.eviware.soapui.analytics.SoapUIActions;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.security.SecurityTest;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Adds a new SecurityTest to a WsdlTestCase
 */

public class AddNewSecurityTestAction extends AbstractSoapUIAction<WsdlTestCase> {
    public static final String SOAPUI_ACTION_ID = "AddNewSecurityTestAction";

    public AddNewSecurityTestAction() {
        super("New SecurityTest", "Creates a new SecurityTest for this TestCase");
    }

    public void perform(WsdlTestCase testCase, Object param) {
        String name = UISupport.prompt("Specify name of SecurityTest", "New SecurityTest",
                "SecurityTest " + (testCase.getSecurityTestCount() + 1));
        if (StringUtils.isNullOrEmpty(name)) {
            return;
        }

        while (testCase.getSecurityTestByName(name.trim()) != null) {
            name = UISupport.prompt("Specify unique name of SecurityTest", "Rename SecurityTest", name);
            if (StringUtils.isNullOrEmpty(name)) {
                return;
            }
        }

        SecurityTest securityTest = testCase.addNewSecurityTest(name);
        UISupport.selectAndShow(securityTest);
        if (param != null && param instanceof SoapUIActions) {
            Analytics.trackAction((SoapUIActions) param);
        } else {
            Analytics.trackAction(SoapUIActions.CREATE_SECURITY_TEST);
        }
    }
}
