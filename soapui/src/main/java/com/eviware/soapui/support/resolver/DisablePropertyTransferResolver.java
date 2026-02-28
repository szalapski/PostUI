

package com.eviware.soapui.support.resolver;

import com.eviware.soapui.impl.wsdl.teststeps.PropertyTransfer;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.resolver.ResolveContext.Resolver;

public class DisablePropertyTransferResolver implements Resolver {
    PropertyTransfer transfer = null;
    private boolean resolved;

    public DisablePropertyTransferResolver(PropertyTransfer transfer) {
        this.transfer = transfer;
    }

    public String toString() {
        return getDescription();
    }

    public String getDescription() {
        return "Disable Property Transfer";
    }

    public String getResolvedPath() {
        return null;
    }

    public boolean isResolved() {
        return resolved;
    }

    public boolean resolve() {
        if (UISupport.confirm("Are you sure you want to disable property?", "Property Disable") && transfer != null) {
            transfer.setDisabled(true);
            resolved = true;
        }
        return resolved;
    }

}
