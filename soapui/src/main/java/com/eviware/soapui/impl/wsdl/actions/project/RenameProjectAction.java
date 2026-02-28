

package com.eviware.soapui.impl.wsdl.actions.project;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Renames a WsdlProject
 *
 * @author Ole.Matzura
 */

public class RenameProjectAction extends AbstractSoapUIAction<WsdlProject> {
    public static final String SOAPUI_ACTION_ID = "RenameProjectAction";

    public RenameProjectAction() {
        super("Rename", "Renames this project");
    }

    public void perform(WsdlProject project, Object param) {
        String name = UISupport.prompt("Specify name of project", "Rename Project", project.getName());
        if (name == null || name.equals(project.getName())) {
            return;
        }
        while (project.getWorkspace().getProjectByName(name.trim()) != null) {
            name = UISupport.prompt("Specify unique name of Project", "Rename Project", project.getName());
            if (name == null || name.equals(project.getName())) {
                return;
            }
        }

        project.setName(name);
    }
}
