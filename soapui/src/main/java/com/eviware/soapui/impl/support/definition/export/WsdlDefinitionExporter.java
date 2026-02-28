

package com.eviware.soapui.impl.support.definition.export;

import com.eviware.soapui.impl.support.definition.InterfaceDefinition;
import com.eviware.soapui.impl.wsdl.WsdlInterface;

public class WsdlDefinitionExporter extends AbstractDefinitionExporter {
    public WsdlDefinitionExporter(WsdlInterface iface) throws Exception {
        this(iface.getWsdlContext().getInterfaceDefinition());
    }

    public WsdlDefinitionExporter(InterfaceDefinition<WsdlInterface> definition) {
        super(definition);
    }

    protected String[] getLocationXPathsToReplace() {
        return new String[]{"declare namespace s='http://schemas.xmlsoap.org/wsdl/' .//s:import/@location",
                "declare namespace s='http://www.w3.org/2001/XMLSchema' .//s:import/@schemaLocation",
                "declare namespace s='http://www.w3.org/2001/XMLSchema' .//s:include/@schemaLocation"};
    }
}
