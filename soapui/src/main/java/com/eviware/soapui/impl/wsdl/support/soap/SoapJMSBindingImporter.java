

package com.eviware.soapui.impl.wsdl.support.soap;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlContext;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlUtils;
import com.eviware.soapui.settings.WsdlSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.wsdl.Binding;
import javax.wsdl.BindingOperation;
import javax.wsdl.extensions.soap.SOAPBinding;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * BindingImporter that can import a WsdlInterface from an SOAP 1.2/HTTP binding
 *
 * @author Ole.Matzura
 */

public class SoapJMSBindingImporter extends AbstractSoapBindingImporter {
    private final static Logger log = LogManager.getLogger(SoapJMSBindingImporter.class);

    public boolean canImport(Binding binding) {
        List<?> list = binding.getExtensibilityElements();
        SOAPBinding soapBinding = WsdlUtils.getExtensiblityElement(list, SOAPBinding.class);
        return soapBinding == null ? false : soapBinding.getTransportURI().startsWith(
                "http://www.soapjms.org/2007/08/soap/bindings/JMS/")
                || soapBinding.getTransportURI().startsWith("http://www.w3.org/2008/07/soap/bindings/JMS/")
                || soapBinding.getTransportURI().startsWith("http://www.w3.org/2010/soapjms/")
                || soapBinding.getTransportURI().startsWith("http://schemas.xmlsoap.org/soap/jms");
    }

    @SuppressWarnings("unchecked")
    public WsdlInterface importBinding(WsdlProject project, WsdlContext wsdlContext, Binding binding) throws Exception {
        String name = project.getSettings().getBoolean(WsdlSettings.NAME_WITH_BINDING) ? binding.getQName()
                .getLocalPart() : binding.getPortType().getQName().getLocalPart();

        WsdlInterface iface = (WsdlInterface) project.addNewInterface(name, WsdlInterfaceFactory.WSDL_TYPE);
        iface.setBindingName(binding.getQName());
        iface.setSoapVersion(SoapVersion.Soap12);

        String[] endpoints = WsdlUtils.getEndpointsForBinding(wsdlContext.getDefinition(), binding);
        for (int i = 0; i < endpoints.length; i++) {
            log.info("importing endpoint " + endpoints[i]);
            iface.addEndpoint(endpoints[i]);
        }

        List<BindingOperation> list = binding.getBindingOperations();
        Collections.sort(list, new BindingOperationComparator());

        for (Iterator<BindingOperation> iter = list.iterator(); iter.hasNext(); ) {
            BindingOperation operation = (BindingOperation) iter.next();

            // sanity check
            if (operation.getOperation() == null || operation.getOperation().isUndefined()) {
                log.error("BindingOperation [" + operation.getName() + "] is missing or referring to an invalid operation");
            } else {
                log.info("importing operation " + operation.getName());
                iface.addNewOperation(operation);
            }
        }

        initWsAddressing(binding, iface, wsdlContext.getDefinition());

        return iface;
    }

}
