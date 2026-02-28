

package com.eviware.soapui.impl.wsdl;

import com.eviware.soapui.impl.WorkspaceImpl;
import com.eviware.soapui.model.project.ProjectFactory;
import com.eviware.soapui.model.workspace.Workspace;
import com.eviware.soapui.support.SoapUIException;
import org.apache.xmlbeans.XmlException;

import java.io.IOException;
import java.io.InputStream;

public class WsdlProjectFactory implements ProjectFactory<WsdlProject> {

    public static final String WSDL_TYPE = "wsdl";

    public WsdlProject createNew() throws XmlException, IOException, SoapUIException {
        return new WsdlProject();
    }

    public WsdlProject createNew(String path) throws XmlException, IOException, SoapUIException {
        return new WsdlProject(path);
    }

    public WsdlProject createNew(String projectFile, String projectPassword) {
        return new WsdlProject(projectFile, (WorkspaceImpl) null, true, null, projectPassword);
    }

    public WsdlProject createNew(Workspace workspace) {
        return new WsdlProject((String) null, (WorkspaceImpl) workspace);
    }

    public WsdlProject createNew(String path, Workspace workspace) {
        return new WsdlProject(path, (WorkspaceImpl) workspace);
    }

    public WsdlProject createNew(String path, Workspace workspace, boolean create) {
        return new WsdlProject(path, (WorkspaceImpl) workspace, true, null, null);
    }

    public WsdlProject createNew(String path, Workspace workspace, boolean open, String tempName,
                                 String projectPassword) {
        return new WsdlProject(path, (WorkspaceImpl) workspace, open, tempName, projectPassword);
    }

    @Override
    public WsdlProject createNew(InputStream inputStream, WorkspaceImpl workspace) {
        return new WsdlProject(inputStream, workspace);
    }

}
