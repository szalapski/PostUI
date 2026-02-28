

package com.eviware.soapui.impl.wsdl.actions.project;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.support.SoapUIException;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

public class OpenAndDecryptProjectAction extends AbstractSoapUIAction<WsdlProject> {

    public static final String SOAPUI_ACTION_ID = "OpenAndDecryptProjectAction";

    public OpenAndDecryptProjectAction() {
        super("Open and Decrypt", "Opens and decrypts this project");
    }

    public void perform(WsdlProject project, Object param) {
        try {
            UISupport.select(project.getWorkspace().openProject(project));
        } catch (SoapUIException e) {
            UISupport.showErrorMessage(e);
        }
    }

}
