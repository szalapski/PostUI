

package com.eviware.soapui.impl;

import com.eviware.soapui.support.MessageSupport;
import com.eviware.soapui.support.components.JPropertiesTable;

import javax.swing.JPanel;

/**
 * PanelBuilder for default Workspace implementation
 *
 * @author ole.matzura
 */

public class WorkspaceImplPanelBuilder extends EmptyPanelBuilder<WorkspaceImpl> {
    public static final MessageSupport messages = MessageSupport.getMessages(WorkspaceImplPanelBuilder.class);

    public WorkspaceImplPanelBuilder() {
    }

    public JPanel buildOverviewPanel(WorkspaceImpl workspace) {
        JPropertiesTable<WorkspaceImpl> table = buildDefaultProperties(workspace, messages.get("OverviewPanel.Title"));
        table.addProperty(messages.get("OverviewPanel.File.Label"), "path", false);
        table.addProperty(messages.get("OverviewPanel.ProjectRoot.Label"), "projectRoot",
                new String[]{null, "${workspaceDir}"}).setDescription(
                messages.get("OverviewPanel.ProjectRoot.Description"));
        return table;
    }

    public boolean hasOverviewPanel() {
        return true;
    }
}
