

package com.eviware.soapui.impl.wsdl.actions.mockoperation;

import com.eviware.soapui.impl.wsdl.mock.WsdlMockService;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import java.io.File;

public class ImportMockOperation extends AbstractSoapUIAction<WsdlMockService> {

    public ImportMockOperation() {
        super("Import Mock Operation", "Import Mock Operation in this Mock Service");
    }

    public void perform(WsdlMockService target, Object param) {
        File file = UISupport.getFileDialogs().openXML(this, "Choose test case to import");

        if (file == null) {
            return;
        }

        String fileName = file.getAbsolutePath();
        if (fileName == null) {
            return;
        }

        target.importMockOperation(file);

    }

}
