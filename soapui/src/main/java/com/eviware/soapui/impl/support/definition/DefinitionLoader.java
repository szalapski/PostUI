

package com.eviware.soapui.impl.support.definition;

import com.eviware.soapui.impl.wsdl.support.xsd.SchemaLoader;
import com.eviware.x.dialogs.XProgressMonitor;

public interface DefinitionLoader extends SchemaLoader {
    void setProgressMonitor(XProgressMonitor monitor, int i);

    void setProgressInfo(String info);

    boolean isAborted();

    boolean abort();

    void setNewBaseURI(String uri);

    String getFirstNewURI();
}
