

package com.eviware.soapui.impl.actions;

import com.eviware.soapui.analytics.Analytics;
import com.eviware.soapui.analytics.SoapUIActions;
import com.eviware.soapui.impl.WorkspaceImpl;
import com.eviware.soapui.support.MessageSupport;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Renames a WsdlProject
 *
 * @author Ole.Matzura
 */

public class RenameWorkspaceAction extends AbstractSoapUIAction<WorkspaceImpl> {
    public static final String SOAPUI_ACTION_ID = "RenameWorkspaceAction";
    public static final MessageSupport messages = MessageSupport.getMessages(RenameWorkspaceAction.class);

    public RenameWorkspaceAction() {
        super(messages.get("Title"), messages.get("Description"));
    }

    public void perform(WorkspaceImpl workspace, Object param) {
        String name = UISupport.prompt(messages.get("Prompt"), messages.get("Prompt.Title"), workspace.getName());
        if (name == null || name.equals(workspace.getName())) {
            return;
        }

        workspace.setName(name);
        Analytics.trackAction(SoapUIActions.RENAME_WORKSPACE);
    }
}
