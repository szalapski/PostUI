

package com.eviware.soapui.impl.wsdl.actions.project;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import java.io.File;

public class ImportTestSuiteAction extends AbstractSoapUIAction<WsdlProject> {
    public ImportTestSuiteAction() {
        super("Import Test Suite", "Import test suite for this interface");
    }

    public void perform(WsdlProject project, Object param) {
        File file = UISupport.getFileDialogs().openXML(this, "Choose test suite to import");

        if (file == null) {
            return;
        }

        String fileName = file.getAbsolutePath();
        if (fileName == null) {
            return;
        }

        project.importTestSuite(file);

    }
}
