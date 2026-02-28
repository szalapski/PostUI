

package com.eviware.soapui.impl.wsdl.teststeps.actions;

import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStepResult;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStepResult;
import com.eviware.soapui.support.UISupport;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.ActionEvent;

/**
 * Creates a request from the specified TestStepResult
 *
 * @author Ole.Matzura
 */

public class CreateRequestAction extends AbstractAction {
    private final WsdlTestRequestStepResult result;

    public CreateRequestAction(WsdlTestStepResult result) {
        this.result = (WsdlTestRequestStepResult) result;

        putValue(Action.SMALL_ICON, UISupport.createImageIcon("/create_request_from_result.gif"));
        putValue(Action.SHORT_DESCRIPTION, "Creates a new request from this result");
    }

    public void actionPerformed(ActionEvent e) {
        WsdlTestRequestStep step = (WsdlTestRequestStep) result.getTestStep();
        String name = UISupport.prompt("Specify name of request", "Create Request", "Result from " + step.getName());

        if (name != null) {
            WsdlOperation operation = (WsdlOperation) step.getTestRequest().getOperation();
            WsdlRequest request = operation.addNewRequest(name);
            request.setRequestContent(result.getRequestContent());
            request.setDomain(result.getDomain());
            request.setEncoding(result.getEncoding());
            request.setEndpoint(result.getEndpoint());
            request.setPassword(result.getPassword());
            request.setUsername(result.getUsername());

            UISupport.showDesktopPanel(request);
        }
    }
}
