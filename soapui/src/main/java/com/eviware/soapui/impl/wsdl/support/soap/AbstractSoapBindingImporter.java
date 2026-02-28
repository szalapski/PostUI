

package com.eviware.soapui.impl.wsdl.support.soap;

import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.support.BindingImporter;
import com.eviware.soapui.impl.wsdl.support.policy.PolicyUtils;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlUtils;

import javax.wsdl.Binding;
import javax.wsdl.BindingOperation;
import javax.wsdl.Definition;
import java.text.Collator;
import java.util.Comparator;

public abstract class AbstractSoapBindingImporter implements BindingImporter {

    protected static final class BindingOperationComparator implements Comparator<BindingOperation> {
        public int compare(BindingOperation o1, BindingOperation o2) {
            return Collator.getInstance().compare(o1.getOperation().getName(), o2.getOperation().getName());
        }
    }

    protected void initWsAddressing(Binding binding, WsdlInterface iface, Definition def) throws Exception {
        iface.setWsaVersion(WsdlUtils.getUsingAddressing(binding));
        // if (iface.getWsaVersion().equals(WsaVersionTypeConfig.NONE.toString()))
        // {
        iface.processPolicy(PolicyUtils.getAttachedPolicy(binding, def));
        // }
    }

    public AbstractSoapBindingImporter() {
        super();
    }

}
