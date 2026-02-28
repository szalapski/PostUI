

package com.eviware.soapui.impl.actions;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.WorkspaceImpl;
import com.eviware.soapui.support.MessageSupport;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Action to clear the current workspace
 *
 * @author ole.matzura
 */

public class ClearWorkspaceAction extends AbstractSoapUIAction<WorkspaceImpl> {
    public static final String SOAPUI_ACTION_ID = "ClearWorkspaceAction";
    public static final MessageSupport messages = MessageSupport.getMessages(ClearWorkspaceAction.class);

    public ClearWorkspaceAction() {
        super(messages.get("ClearWorkspaceAction.Title"), messages.get("ClearWorkspaceAction.Description"));
    }

    public void perform(WorkspaceImpl workspace, Object param) {
        if (SoapUI.getTestMonitor().hasRunningTests()) {
            UISupport.showErrorMessage(messages.get("ClearWorkspaceAction.WhileTestsAreRunningError"));
            return;
        }

        if (!UISupport.confirm(messages.get("ClearWorkspaceAction.ConfirmQuestion"),
                messages.get("ClearWorkspaceAction.Title"))) {
            return;
        }

        if (SoapUI.getDesktop().closeAll()) {
            while (workspace.getProjectCount() > 0) {
                workspace.removeProject(workspace.getProjectAt(0));
            }
        }
    }
}
