

package com.eviware.soapui.impl.wsdl.mock;

import com.eviware.soapui.impl.support.BaseMockResult;
import com.eviware.soapui.impl.wsdl.panels.mockoperation.WsdlMockResultMessageExchange;
import com.eviware.soapui.impl.wsdl.teststeps.actions.ShowMessageExchangeAction;
import com.eviware.soapui.support.action.swing.ActionList;

import java.util.Vector;

/**
 * The result of a handled WsdlMockRequest
 *
 * @author ole.matzura
 */

public class WsdlMockResult extends BaseMockResult<WsdlMockRequest, WsdlMockOperation> {
    public WsdlMockResult(WsdlMockRequest request) {
        super(request);
    }

    public Vector<?> getRequestWssResult() {
        return getMockRequest().getWssResult();
    }

    @Override
    public ActionList getActions() {
        ActionList actionList = super.getActions();

        actionList.setDefaultAction(createMessageExchangeAction());

        return actionList;
    }

    private ShowMessageExchangeAction createMessageExchangeAction() {
        return new ShowMessageExchangeAction(createMessageExchange(), "MockResult");
    }

    private WsdlMockResultMessageExchange createMessageExchange() {
        WsdlMockResponse mockResponse = (WsdlMockResponse) getMockResponse();
        return new WsdlMockResultMessageExchange(this, mockResponse);
    }


}
