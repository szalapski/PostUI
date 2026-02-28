

package com.eviware.soapui.impl.wsdl.actions.iface.tools.soapui;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.loadtest.WsdlLoadTest;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.action.SoapUIAction;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

public class LoadTestLoadTestRunnerAction extends AbstractSoapUIAction<WsdlLoadTest> {
    public LoadTestLoadTestRunnerAction() {
        super("Launch LoadTestRunner", "Launch the SoapUI commandline TestRunner for this TestCase");
    }

    public void perform(WsdlLoadTest target, Object param) {
        SoapUIAction<ModelItem> action = SoapUI.getActionRegistry().getAction(LoadTestRunnerAction.SOAPUI_ACTION_ID);
        SoapUI.setLaunchedTestRunner(true);
        action.perform(target.getTestCase().getTestSuite().getProject(), target);
    }
}
