

package com.eviware.soapui.impl.wsdl.actions.project;

import com.eviware.soapui.analytics.Analytics;
import com.eviware.soapui.analytics.SoapUIActions;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.mock.WsdlMockService;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Action for adding a new WsdlMockService to a WsdlProject
 *
 * @author Ole.Matzura
 */

public class AddNewMockServiceAction extends AbstractSoapUIAction<WsdlProject> {
    public static final String SOAPUI_ACTION_ID = "AddNewWSDLMockServiceAction";

    public AddNewMockServiceAction() {
        super("New SOAP MockService", "Creates a new SOAP MockService in this project");
        // putValue( Action.ACCELERATOR_KEY, UISupport.getKeyStroke( "menu O" ));
    }

    public void perform(WsdlProject target, Object param) {
        if (createMockService(target) != null) {
            Analytics.trackAction(SoapUIActions.CREATE_SOAP_MOCK);
        }
    }

    public WsdlMockService createMockService(WsdlProject project) {
        String name = UISupport.prompt("Specify name of MockService", "New MockService",
                "MockService " + (project.getMockServiceCount() + 1));
        if (name == null) {
            return null;
        }
        while (project.getMockServiceByName(name.trim()) != null) {
            name = UISupport.prompt("Specify unique name of MockService", "Rename MockService", name);
        }

        WsdlMockService mockService = project.addNewMockService(name);
        UISupport.select(mockService);

        return mockService;
    }
}
