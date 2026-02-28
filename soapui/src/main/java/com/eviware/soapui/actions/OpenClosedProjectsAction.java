

package com.eviware.soapui.actions;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.WorkspaceImpl;
import com.eviware.soapui.model.project.Project;
import com.eviware.soapui.support.SoapUIException;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Action to save all projects
 *
 * @author ole.matzura
 */

public class OpenClosedProjectsAction extends AbstractSoapUIAction<WorkspaceImpl> {
    public static final String SOAPUI_ACTION_ID = "OpenClosedProjectsAction";

    public OpenClosedProjectsAction() {
        super("Open All Closed Projects", "Opens all closed projects in the current Workspace");
    }

    public void perform(WorkspaceImpl workspace, Object param) {
        List<Project> openProjects = new ArrayList<>();
        for (Project project : workspace.getProjectList()) {
            if (!project.isOpen() && !project.isDisabled()) {
                openProjects.add(project);
            }
        }

        if (openProjects.isEmpty()) {
            UISupport.showErrorMessage("No closed projects in workspace");
            return;
        }

        for (Project project : openProjects) {
            try {
                workspace.openProject(project);
            } catch (SoapUIException e) {
                SoapUI.logError(e);
            }
        }
    }
}
