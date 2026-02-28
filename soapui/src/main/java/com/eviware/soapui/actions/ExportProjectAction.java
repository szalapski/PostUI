

package com.eviware.soapui.actions;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.analytics.Analytics;
import com.eviware.soapui.analytics.SoapUIActions;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.integration.exporter.ProjectExporter;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import java.io.File;

public class ExportProjectAction extends AbstractSoapUIAction<WsdlProject> {

    public ExportProjectAction() {
        super("Export Project", "Export Project");
    }

    @Override
    public void perform(WsdlProject project, Object param) {
        ProjectExporter exporter = new ProjectExporter(project);

        try {
            String path = project.getPath();
            if (path == null) {
                project.save();
            } else {
                File file = UISupport.getFileDialogs().saveAs(this, "Select file to export project", "zip", "zip",
                        new File(System.getProperty("user.home")));
                if (file == null) {
                    return;
                }

                String fileName = file.getAbsolutePath();
                if (fileName == null) {
                    return;
                }

                exporter.exportProject(fileName);
                Analytics.trackAction(SoapUIActions.EXPORT_PROJECT);
            }
        } catch (Exception e1) {
            SoapUI.logError(e1, "Failed to export project");
            UISupport.showErrorMessage("Failed to export project; " + e1);
        }

    }

}
