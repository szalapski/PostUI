

package com.eviware.soapui.impl.wsdl.actions.mockoperation;

import com.eviware.soapui.impl.rest.mock.RestMockAction;
import com.eviware.soapui.impl.support.AbstractMockOperation;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Renames a WsdlMockOperation
 *
 * @author Ole.Matzura
 */

public class RenameMockOperationAction extends AbstractSoapUIAction<AbstractMockOperation> {
    public RenameMockOperationAction() {
        super("Rename", "Renames this node");
    }

    public void perform(AbstractMockOperation mockOperation, Object param) {
        String nodeName = mockOperation instanceof RestMockAction ? "RestMockAction" : "MockOperation";
        String name = UISupport.prompt("Specify name of " + nodeName, "Rename " + nodeName, mockOperation.getName());
        if (name == null || name.equals(mockOperation.getName())) {
            return;
        }

        mockOperation.setName(name);
    }

}
