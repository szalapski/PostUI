

package com.eviware.soapui.impl.wsdl.actions.mockservice;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.support.AbstractInterface;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.mock.WsdlMockService;
import com.eviware.soapui.model.support.ModelSupport;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Adds the specified WsdlMockServices local endpoint to a WsdlInterface
 *
 * @author Ole.Matzura
 */

public class AddEndpointToInterfaceAction extends AbstractSoapUIAction<WsdlMockService> {
    public AddEndpointToInterfaceAction() {
        super("Add Endpoint to Interface", "Adds this MockService's endpoint to the selected Interface");
    }

    public void perform(WsdlMockService mockService, Object param) {
        String[] names = ModelSupport.getNames(mockService.getProject().getInterfaceList(),
                new ModelSupport.InterfaceTypeFilter(WsdlInterfaceFactory.WSDL_TYPE));

        String ifaceName = UISupport.prompt("Select Interface to add MockService endpoint to", "Add Endpoint", names,
                null);

        if (ifaceName != null) {
            WsdlProject project = mockService.getProject();
            AbstractInterface<?> iface = project.getInterfaceByName(ifaceName);
            if (iface != null) {
                iface.addEndpoint(mockService.getLocalEndpoint());
                UISupport.showInfoMessage("Add endpoint [" + mockService.getLocalEndpoint() + "] to " + "Interface ["
                        + ifaceName + "]");
            }
        }
    }
}
