

package com.eviware.soapui.actions;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.WorkspaceImpl;
import com.eviware.soapui.model.project.Project;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Action to save all projects
 *
 * @author ole.matzura
 */

public class CloseOpenProjectsAction extends AbstractSoapUIAction<WorkspaceImpl> {
    public static final String SOAPUI_ACTION_ID = "CloseOpenProjectsAction";
    public static final String NAME = "Close All Open Projects";

    public CloseOpenProjectsAction() {
        super(NAME, "Closes all open projects in the current Workspace");
    }

    public void perform(WorkspaceImpl workspace, Object param) {
        List<Project> openProjects = new ArrayList<>();
        for (Project project : workspace.getProjectList()) {
            if (project.isOpen()) {
                openProjects.add(project);
            }
        }

        if (openProjects.isEmpty()) {
            UISupport.showErrorMessage("No open projects in workspace");
            return;
        }

        Boolean coc = UISupport.confirmOrCancel("Save projects before closing?", getName());
        if (coc == null) {
            return;
        }

        for (Project project : openProjects) {
            try {
                if (coc) {
                    project.save();
                }

                workspace.closeProject(project);
            } catch (IOException e) {
                SoapUI.logError(e);
            }
        }
    }
}
