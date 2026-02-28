

package com.eviware.soapui.impl.wsdl.actions.project;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;
import com.eviware.soapui.support.resolver.ResolveDialog;

/**
 * Renames a WsdlProject
 *
 * @author Ole.Matzura
 */

public class ResolveProjectAction extends AbstractSoapUIAction<WsdlProject> {
    public static final String SOAPUI_ACTION_ID = "ResolveProjectAction";

    private ResolveDialog dialog;

    public ResolveProjectAction() {
        super("Resolve", "Resolve item dependencies in this project");
    }

    public void perform(WsdlProject project, Object param) {
        if (dialog == null) {
            dialog = new ResolveDialog(getName(), getDescription(), null);
            dialog.setShowOkMessage(true);
        }

        dialog.resolve(project);
    }
}
