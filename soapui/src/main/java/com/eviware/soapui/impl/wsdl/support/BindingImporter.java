

package com.eviware.soapui.impl.wsdl.support;

import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlContext;

import javax.wsdl.Binding;

/**
 * Behaviour for a class that can create a WsdlInterface from a WSDL binding
 *
 * @author Ole.Matzura
 */

public interface BindingImporter {
    public boolean canImport(Binding binding);

    public WsdlInterface importBinding(WsdlProject project, WsdlContext wsdlContext, Binding binding) throws Exception;
}
