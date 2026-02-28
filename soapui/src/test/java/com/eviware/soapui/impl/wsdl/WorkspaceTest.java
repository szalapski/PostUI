

package com.eviware.soapui.impl.wsdl;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.model.workspace.Workspace;
import com.eviware.soapui.model.workspace.WorkspaceFactory;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;

public class WorkspaceTest {

    @Test
    public void testWorkspaceImpl() throws Exception {
        Workspace workspace = WorkspaceFactory.getInstance().openWorkspace(
                System.getProperty("user.home", ".") + File.separatorChar + SoapUI.DEFAULT_WORKSPACE_FILE, null);

        for (int c = 0; c < workspace.getProjectCount(); c++) {
            assertNotNull(workspace.getProjectAt(c).getName());
        }
    }
}
