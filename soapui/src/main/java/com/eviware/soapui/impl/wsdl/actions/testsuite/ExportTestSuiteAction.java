

package com.eviware.soapui.impl.wsdl.actions.testsuite;

import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import java.io.File;

public class ExportTestSuiteAction extends AbstractSoapUIAction<WsdlTestSuite> {

    public ExportTestSuiteAction() {
        super("Export", "Export this test suite");
    }

    public void perform(WsdlTestSuite tSuite, Object param) {
        tSuite.beforeSave();
        String defaultFileName = System.getProperty("user.home") + File.separator
                + StringUtils.createFileName(tSuite.getName(), '-') + ".xml";
        File file = UISupport.getFileDialogs().saveAs(this, "Select test case file", "xml", "XML",
                new File(defaultFileName));

        if (file == null) {
            return;
        }

        String fileName = file.getAbsolutePath();
        if (fileName == null) {
            return;
        }

        tSuite.export(file);
    }

}
