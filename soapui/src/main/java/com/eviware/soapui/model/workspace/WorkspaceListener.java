

package com.eviware.soapui.model.workspace;

import com.eviware.soapui.model.iface.SoapUIListener;
import com.eviware.soapui.model.project.Project;

/**
 * Listener for Workspace-related events
 *
 * @author Ole.Matzura
 */

public interface WorkspaceListener extends SoapUIListener {
    public void projectAdded(Project project);

    public void projectRemoved(Project project);

    public void projectChanged(Project project);

    public void projectOpened(Project project);

    public void projectClosed(Project project);

    public void workspaceSwitching(Workspace workspace);

    public void workspaceSwitched(Workspace workspace);
}
