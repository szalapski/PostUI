

package com.eviware.soapui.impl.wsdl.actions.iface.tools.soapui;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.actions.iface.tools.support.SecurityTestRunnerAction;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.security.SecurityTest;
import com.eviware.soapui.support.action.SoapUIAction;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

public class SecurityTestSecurityTestRunnerAction extends AbstractSoapUIAction<SecurityTest> {

    public SecurityTestSecurityTestRunnerAction() {
        super("Launch SecurityTestRunner", "Launch command-line SecurityTestRunner for this SecurityTest");
    }

    @Override
    public void perform(SecurityTest target, Object param) {
        SoapUIAction<ModelItem> action = SoapUI.getActionRegistry().getAction(SecurityTestRunnerAction.SOAPUI_ACTION_ID);
        SoapUI.setLaunchedTestRunner(true);
        action.perform(target.getTestCase().getTestSuite().getProject(), target);
    }

}
