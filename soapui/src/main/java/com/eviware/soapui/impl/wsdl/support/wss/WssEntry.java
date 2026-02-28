

package com.eviware.soapui.impl.wsdl.support.wss;

import com.eviware.soapui.config.WSSEntryConfig;
import com.eviware.soapui.model.propertyexpansion.PropertyExpansionContext;
import com.eviware.soapui.support.registry.RegistryEntry;
import org.apache.ws.security.message.WSSecHeader;
import org.w3c.dom.Document;

import javax.swing.JComponent;

public interface WssEntry extends RegistryEntry<WSSEntryConfig, OutgoingWss> {
    public void process(WSSecHeader secHeader, Document doc, PropertyExpansionContext context);

    public JComponent getConfigurationPanel();

    public String getLabel();

    public OutgoingWss getOutgoingWss();

    public void updateEntryConfig(WSSEntryConfig config);

    public void release();
}
