

package com.eviware.soapui.impl.wsdl.actions.mockresponse;

import com.eviware.soapui.impl.wsdl.AbstractWsdlModelItem;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Renames the specified WsdlMockResponse
 *
 * @author ole.matzura
 */

public class RenameMockResponseAction extends AbstractSoapUIAction<AbstractWsdlModelItem> {
    public RenameMockResponseAction() {
        super("Rename", "Renames this MockResponse");
    }

    public void perform(AbstractWsdlModelItem modelItem, Object param) {
        String name = UISupport.prompt("Specify name of MockResponse", getName(), modelItem.getName());
        if (name == null || name.equals(modelItem.getName())) {
            return;
        }

        modelItem.setName(name);
    }
}
