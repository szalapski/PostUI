

package com.eviware.soapui.impl.wsdl.actions.mockservice;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import java.io.File;

public class ImportMockService extends AbstractSoapUIAction<WsdlProject> {

    public ImportMockService() {
        super("Import Mock Service", "Import Mock Service");
    }

    public void perform(WsdlProject project, Object param) {
        File file = UISupport.getFileDialogs().openXML(this, "Choose mock service to import");

        if (file == null) {
            return;
        }

        String fileName = file.getAbsolutePath();
        if (fileName == null) {
            return;
        }

        project.importMockService(file);

    }

}
