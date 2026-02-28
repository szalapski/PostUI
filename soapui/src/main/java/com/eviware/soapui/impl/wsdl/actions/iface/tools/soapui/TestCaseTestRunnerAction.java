

package com.eviware.soapui.impl.wsdl.actions.iface.tools.soapui;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.action.SoapUIAction;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

public class TestCaseTestRunnerAction extends AbstractSoapUIAction<WsdlTestCase> {
    public TestCaseTestRunnerAction() {
        super("Launch TestRunner", "Launch the SoapUI commandline TestRunner for this TestCase");
    }

    public void perform(WsdlTestCase target, Object param) {
        SoapUIAction<ModelItem> action = SoapUI.getActionRegistry().getAction(TestRunnerAction.SOAPUI_ACTION_ID);
        SoapUI.setLaunchedTestRunner(true);
        action.perform(target.getTestSuite().getProject(), target);
    }
}
