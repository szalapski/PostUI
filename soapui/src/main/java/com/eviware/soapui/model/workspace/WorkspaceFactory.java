

package com.eviware.soapui.model.workspace;

import com.eviware.soapui.impl.WorkspaceFactoryImpl;
import com.eviware.soapui.support.SoapUIException;
import com.eviware.soapui.support.types.StringToStringMap;

/**
 * Factory class for creating Workspaces
 *
 * @author Ole.Matzura
 */

public abstract class WorkspaceFactory {
    private static WorkspaceFactory instance;

    public static WorkspaceFactory getInstance() {
        if (instance == null) {
            instance = new WorkspaceFactoryImpl();
        }

        return instance;
    }

    public abstract Workspace openWorkspace(String workspaceName, StringToStringMap projectOptions)
            throws SoapUIException;
}
