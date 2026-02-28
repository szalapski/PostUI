

package com.eviware.soapui.impl.wsdl.actions.mockservice;

import com.eviware.soapui.impl.wsdl.mock.WsdlMockService;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import java.io.File;

public class ExportMockService extends AbstractSoapUIAction<WsdlMockService> {

    public ExportMockService() {
        super("Export", "Export this mock service");
    }

    public void perform(WsdlMockService mService, Object param) {
        mService.beforeSave();
        String defaultFileName = System.getProperty("user.home") + File.separator + mService.getName() + ".xml";
        File file = UISupport.getFileDialogs().saveAs(this, "Select test case file", "xml", "XML",
                new File(defaultFileName));

        if (file == null) {
            return;
        }

        String fileName = file.getAbsolutePath();
        if (fileName == null) {
            return;
        }

        mService.export(file);
    }

}
