

package com.eviware.soapui.impl.wsdl.support.wsdl;

import com.eviware.soapui.impl.support.definition.support.InvalidDefinitionException;
import com.eviware.soapui.impl.support.definition.support.XmlSchemaBasedInterfaceDefinition;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;

public class WsdlInterfaceDefinition extends XmlSchemaBasedInterfaceDefinition<WsdlInterface> {
    private Definition definition;

    private static WSDLFactory factory;
    private static WSDLReader wsdlReader;
    private Logger log = LogManager.getLogger(WsdlInterfaceDefinition.class);

    public WsdlInterfaceDefinition(WsdlInterface iface) {
        super(iface);
    }

    public WsdlInterfaceDefinition load(WsdlDefinitionLoader loader) throws Exception {
        if (factory == null) {
            factory = WSDLFactory.newInstance();
            wsdlReader = factory.newWSDLReader();
            wsdlReader.setFeature("javax.wsdl.verbose", true);
            wsdlReader.setFeature("javax.wsdl.importDocuments", true);
        }

        log.debug("Loading WSDL: " + loader.getBaseURI());
        try {
            definition = wsdlReader.readWSDL(loader);
        } catch (WSDLException e) {
            throw new InvalidDefinitionException(e);
        }

        if (!loader.isAborted()) {
            super.loadSchemaTypes(loader);
        } else {
            throw new Exception("Loading of WSDL from [" + loader.getBaseURI() + "] was aborted");
        }

        return this;
    }

    public String getTargetNamespace() {
        return WsdlUtils.getTargetNamespace(definition);
    }

    public Definition getWsdlDefinition() {
        return definition;
    }
}
