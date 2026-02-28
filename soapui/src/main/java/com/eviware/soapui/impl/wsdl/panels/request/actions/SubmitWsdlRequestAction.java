

package com.eviware.soapui.impl.wsdl.panels.request.actions;

import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

public class SubmitWsdlRequestAction extends AbstractSoapUIAction<WsdlRequest> {
    public SubmitWsdlRequestAction() {
        super("Submit", "Submits Request to configured endpoint");
    }

    public void perform(WsdlRequest target, Object param) {

    }
}
