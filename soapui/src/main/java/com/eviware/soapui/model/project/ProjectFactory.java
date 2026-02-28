

package com.eviware.soapui.model.project;

import com.eviware.soapui.impl.WorkspaceImpl;
import com.eviware.soapui.model.workspace.Workspace;
import com.eviware.soapui.support.SoapUIException;
import org.apache.xmlbeans.XmlException;

import java.io.IOException;
import java.io.InputStream;

public interface ProjectFactory<T extends Project> {
    public T createNew() throws XmlException, IOException, SoapUIException;

    public T createNew(String path) throws XmlException, IOException, SoapUIException;

    public T createNew(String projectFile, String projectPassword);

    public T createNew(Workspace workspace);

    public T createNew(String path, Workspace workspace);

    public T createNew(String path, Workspace workspace, boolean open, String tempName,
                       String projectPassword);

    public T createNew(InputStream inputStream, WorkspaceImpl workspace);
}
