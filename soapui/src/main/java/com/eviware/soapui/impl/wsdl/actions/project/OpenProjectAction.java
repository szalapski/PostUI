

package com.eviware.soapui.impl.wsdl.actions.project;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.support.SoapUIException;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Renames a WsdlProject
 *
 * @author Ole.Matzura
 */

public class OpenProjectAction extends AbstractSoapUIAction<WsdlProject> {
    public static final String SOAPUI_ACTION_ID = "OpenProjectAction";

    public OpenProjectAction() {
        super("Open", "Opens this project");
    }

    public void perform(final WsdlProject project, Object param) {
        try {
            UISupport.select(project.getWorkspace().openProject(project));
        } catch (SoapUIException e) {
            UISupport.showErrorMessage(e);
        }
    }
}
