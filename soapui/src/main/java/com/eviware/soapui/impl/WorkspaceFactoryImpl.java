

package com.eviware.soapui.impl;

import com.eviware.soapui.model.workspace.Workspace;
import com.eviware.soapui.model.workspace.WorkspaceFactory;
import com.eviware.soapui.support.SoapUIException;
import com.eviware.soapui.support.types.StringToStringMap;

/**
 * Default WorkspaceFactory implementation
 *
 * @author Ole.Matzura
 */

public class WorkspaceFactoryImpl extends WorkspaceFactory {
    public Workspace openWorkspace(String workspaceName, StringToStringMap projectOptions) throws SoapUIException {
        try {
            return new WorkspaceImpl(workspaceName, projectOptions);
        } catch (Exception e) {
            throw new SoapUIException(e);
        }
    }
}
