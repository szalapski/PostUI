

package com.eviware.soapui.model.project;

import com.eviware.soapui.impl.wsdl.submit.RequestFilter;
import com.eviware.soapui.model.iface.Interface;

import javax.swing.JComponent;

public interface EndpointStrategy extends RequestFilter {
    public void init(Project project);

    public JComponent getConfigurationPanel(Interface iface);

    public void onSave();

    public void release();

    public void importEndpoints(Interface iface);
}
