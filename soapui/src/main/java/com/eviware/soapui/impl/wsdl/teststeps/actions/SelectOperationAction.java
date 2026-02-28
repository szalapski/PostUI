

package com.eviware.soapui.impl.wsdl.teststeps.actions;

import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Selects the specified WsdlTestRequestSteps operation in the navigator
 *
 * @author Ole.Matzura
 */

public class SelectOperationAction extends AbstractSoapUIAction<WsdlTestRequestStep> {
    public SelectOperationAction() {
        super("Select Operation", "Selects this TestRequests' Operation in the navigator");
    }

    public void perform(WsdlTestRequestStep target, Object param) {
        UISupport.select(target.getTestRequest().getOperation());
    }
}
