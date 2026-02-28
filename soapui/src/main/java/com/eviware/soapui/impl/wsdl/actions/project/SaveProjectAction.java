

package com.eviware.soapui.impl.wsdl.actions.project;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import java.io.IOException;

/**
 * Saves a WsdlProject
 *
 * @author Ole.Matzura
 */

public class SaveProjectAction extends AbstractSoapUIAction<WsdlProject> {
    public static final String SOAPUI_ACTION_ID = "SaveProjectAction";

    public SaveProjectAction() {
        super("Save Project", "Saves this project");
    }

    public void perform(WsdlProject project, Object param) {
        try {
            if (StringUtils.hasContent(project.getPath()) || project.getWorkspace() == null) {
                project.save();
            } else {
                project.save(project.getWorkspace().getProjectRoot());
            }
        } catch (IOException e1) {
            UISupport.showErrorMessage("Failed to save project; " + e1);
        }
    }
}
