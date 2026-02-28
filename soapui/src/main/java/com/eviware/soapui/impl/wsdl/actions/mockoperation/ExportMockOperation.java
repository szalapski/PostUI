

package com.eviware.soapui.impl.wsdl.actions.mockoperation;

import com.eviware.soapui.impl.wsdl.mock.WsdlMockOperation;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import java.io.File;

public class ExportMockOperation extends AbstractSoapUIAction<WsdlMockOperation> {
    public ExportMockOperation() {
        super("Export", "Exports the mock operation");
    }

    public void perform(WsdlMockOperation mOperation, Object param) {
        mOperation.beforeSave();
        String defaultFileName = System.getProperty("user.home", ".") + File.separator + mOperation.getName() + ".xml";
        File file = UISupport.getFileDialogs().saveAs(this, "Select test case file", "xml", "XML",
                new File(defaultFileName));

        if (file == null) {
            return;
        }

        String fileName = file.getAbsolutePath();
        if (fileName == null) {
            return;
        }

        mOperation.exportMockOperation(file);
    }
}
