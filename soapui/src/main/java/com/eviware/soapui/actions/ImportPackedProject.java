

package com.eviware.soapui.actions;

import com.eviware.soapui.analytics.Analytics;
import com.eviware.soapui.analytics.SoapUIActions;
import com.eviware.soapui.impl.WorkspaceImpl;
import com.eviware.soapui.impl.actions.ImportWsdlProjectAction;
import com.eviware.soapui.integration.exporter.ProjectExporter;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import java.io.File;
import java.util.List;

public class ImportPackedProject extends AbstractSoapUIAction<WorkspaceImpl> {
    public ImportPackedProject() {
        super("Import Packed Project", "Import Packed Project");
    }

    @Override
    public void perform(WorkspaceImpl workspace, Object param) {

        try {

            File target = UISupport.getFileDialogs().open(this, "Select file to unpack project", "zip", "zip",
                    System.getProperty("user.home"));
            if (target == null) {
                return;
            }

            String fileName = target.getAbsolutePath();
            if (fileName == null) {
                return;
            }

            File dest = UISupport.getFileDialogs().saveAsDirectory(this, "Select where to unpack it",
                    new File(System.getProperty("user.home")));

            if (dest == null || dest.getAbsoluteFile() == null) {
                return;
            }
            ProjectExporter.unpackageAll(fileName, dest.getAbsolutePath());
            List<String> contents = ProjectExporter.getZipContents(fileName);

            for (String fName : dest.list()) {
                if (contents.contains(fName) && fName.endsWith("-soapui-project.xml")) {
                    new ImportWsdlProjectAction().perform(workspace, new File(dest, fName).getAbsoluteFile());
                    break;
                }
            }

            Analytics.trackAction(SoapUIActions.IMPORT_PACKED_PROJECT);
        } catch (Exception e1) {
            UISupport.showErrorMessage("Failed to export project; " + e1);
        }

    }

}
