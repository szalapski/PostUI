

package com.eviware.soapui.impl.wsdl.actions.testcase;

import com.eviware.soapui.analytics.Analytics;
import com.eviware.soapui.analytics.SoapUIActions;
import com.eviware.soapui.impl.wsdl.loadtest.WsdlLoadTest;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Adds a new WsdlLoadTest to a WsdlTestCase
 *
 * @author Ole.Matzura
 */

public class AddNewLoadTestAction extends AbstractSoapUIAction<WsdlTestCase> {
    public static final String SOAPUI_ACTION_ID = "AddNewLoadTestAction";

    public AddNewLoadTestAction() {
        super("New LoadTest", "Creates a new LoadTest for this TestCase");
    }

    public void perform(WsdlTestCase testCase, Object param) {

        String name = UISupport.prompt("Specify name of LoadTest", "New LoadTest",
                "LoadTest " + (testCase.getLoadTestCount() + 1));
        if (name == null) {
            return;
        }

        WsdlLoadTest loadTest = testCase.addNewLoadTest(name);
        UISupport.selectAndShow(loadTest);
        if (param != null && param instanceof SoapUIActions) {
            Analytics.trackAction((SoapUIActions) param);
        } else {
            Analytics.trackAction(SoapUIActions.CREATE_LOAD_TEST);
        }
    }
}
