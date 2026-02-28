

package com.eviware.soapui.model.support;

import com.eviware.soapui.model.project.Project;
import com.eviware.soapui.model.workspace.Workspace;
import com.eviware.soapui.model.workspace.WorkspaceListener;

/**
 * Adapter for WorkspaceListener implementations
 *
 * @author Ole.Matzura
 */

public class WorkspaceListenerAdapter implements WorkspaceListener {
    public void projectAdded(Project project) {
    }

    public void projectRemoved(Project project) {
    }

    public void projectChanged(Project project) {
    }

    public void workspaceSwitched(Workspace workspace) {
    }

    public void workspaceSwitching(Workspace workspace) {
    }

    public void projectClosed(Project project) {
    }

    public void projectOpened(Project project) {
    }
}
