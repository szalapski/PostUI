

package com.eviware.soapui.impl.wsdl.actions.operation;

import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Changes the label of a WsdlOperation as shown in SoapUI
 *
 * @author Ole.Matzura
 */

public class RelabelOperationAction extends AbstractSoapUIAction<WsdlOperation> {
    public RelabelOperationAction() {
        super("Relabel", "Relabel this operation");
    }

    public void perform(WsdlOperation operation, Object param) {
        String name = UISupport.prompt("Specify label for operation\n(will not change underlying wsdl operation name)",
                "Relabel Operation", operation.getName());
        if (name == null || name.equals(operation.getName())) {
            return;
        }

        operation.setName(name);
    }
}
