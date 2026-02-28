

package com.eviware.soapui.impl.wsdl.actions.project;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.iface.Interface;
import com.eviware.soapui.model.propertyexpansion.resolvers.providers.ProjectDirProvider;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import java.io.File;

/**
 * Adds a WsdlInterface to a WsdlProject from a wsdl file
 *
 * @author Ole.Matzura
 */

public class AddInterfaceActionFromFile extends AbstractSoapUIAction<WsdlProject> {
    public static final String SOAPUI_ACTION_ID = "AddInterfaceActionFromFile";

    public AddInterfaceActionFromFile() {
        super("Add WSDL from File", "Adds all interfaces in a specified local WSDL file to the current project");
    }

    public void perform(WsdlProject project, Object param) {
        File file = UISupport.getFileDialogs().open(this, "Select WSDL file", ".wsdl", "WSDL Files (*.wsdl)",
                ProjectDirProvider.getProjectFolder(project));
        if (file == null) {
            return;
        }

        String path = file.getAbsolutePath();
        if (path == null) {
            return;
        }

        try {
            Boolean createRequests = UISupport.confirmOrCancel("Create default requests for all operations",
                    "Import WSDL");
            if (createRequests == null) {
                return;
            }

            Interface[] ifaces = WsdlInterfaceFactory
                    .importWsdl(project, file.toURI().toURL().toString(), createRequests);
            if (ifaces.length > 0) {
                UISupport.select(ifaces[0]);
            }
        } catch (Exception ex) {
            UISupport.showErrorMessage(ex.getMessage() + ":" + ex.getCause());
        }
    }
}
