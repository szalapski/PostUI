

package com.eviware.soapui.impl.wsdl.actions.testcase;

import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import java.io.File;

public class ExportTestCaseAction extends AbstractSoapUIAction<WsdlTestCase> {

    public ExportTestCaseAction() {
        super("Export", "Exports the test case");
    }

    public void perform(WsdlTestCase testCase, Object param) {
        testCase.beforeSave();
        String defaultFileName = System.getProperty("user.home", ".") + File.separator
                + StringUtils.createFileName(testCase.getName(), '-') + ".xml";
        File file = UISupport.getFileDialogs().saveAs(this, "Select test case file", "xml", "XML",
                new File(defaultFileName));

        if (file == null) {
            return;
        }

        String fileName = file.getAbsolutePath();
        if (fileName == null) {
            return;
        }

        testCase.exportTestCase(file);
    }
}
