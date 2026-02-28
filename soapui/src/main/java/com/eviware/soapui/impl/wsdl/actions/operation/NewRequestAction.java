

package com.eviware.soapui.impl.wsdl.actions.operation;

import com.eviware.soapui.analytics.Analytics;
import com.eviware.soapui.analytics.SoapUIActions;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.settings.WsdlSettings;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Adds a new WsdlRequest to a WsdlOperation
 *
 * @author Ole.Matzura
 */

public class NewRequestAction extends AbstractSoapUIAction<WsdlOperation> {
    public final static String SOAPUI_ACTION_ID = "NewRequestAction";

    public NewRequestAction() {
        super("New request", "Creates a new request for this operation");
    }

    public void perform(WsdlOperation operation, Object param) {

        String name = UISupport.prompt("Specify name of request", "New request",
                "Request " + (operation.getRequestCount() + 1));
        if (name == null) {
            return;
        }

        boolean createOptional = operation.getSettings().getBoolean(
                WsdlSettings.XML_GENERATION_ALWAYS_INCLUDE_OPTIONAL_ELEMENTS);
        if (!createOptional) {
            createOptional = UISupport.confirm("Create optional elements in schema?", "Create Request");
        }

        WsdlRequest newRequest = operation.addNewRequest(name);
        String requestContent = operation.createRequest(createOptional);
        if (requestContent != null) {
            newRequest.setRequestContent(requestContent);
        }

        UISupport.showDesktopPanel(newRequest);

        Analytics.trackAction(SoapUIActions.CREATE_REQUEST_FOR_OPERATION);
    }
}
