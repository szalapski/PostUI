

package com.eviware.soapui.model.workspace;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.project.Project;
import com.eviware.soapui.model.project.SaveStatus;
import com.eviware.soapui.support.SoapUIException;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * SoapUI workspace behaviour
 *
 * @author Ole.Matzura
 */

public interface Workspace extends ModelItem {
    public Project getProjectAt(int index);

    public Project getProjectByName(String projectName);

    public int getProjectCount();

    public SaveStatus onClose();

    public SaveStatus save(boolean workspaceOnly);

    public void addWorkspaceListener(WorkspaceListener listener);

    public void removeWorkspaceListener(WorkspaceListener listener);

    public Project createProject(String name, File file) throws SoapUIException;

    public void removeProject(Project project);

    public Project importProject(String filename) throws SoapUIException;

    public Project importProject(InputStream inputStream);

    public int getIndexOfProject(Project project);

    public String getPath();

    public List<? extends Project> getProjectList();

    public void switchWorkspace(File newPath) throws SoapUIException;

    public Project openProject(Project modelItem) throws SoapUIException;

    public void inspectProjects();

    public boolean isSupportInformationDialog();

    public void setSupportInformationDialog(boolean value);
}
