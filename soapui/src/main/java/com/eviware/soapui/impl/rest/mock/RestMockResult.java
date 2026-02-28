

package com.eviware.soapui.impl.rest.mock;

import javax.swing.Action;

import com.eviware.soapui.impl.rest.RestMockResultMessageExchange;
import com.eviware.soapui.impl.support.BaseMockResult;
import com.eviware.soapui.impl.wsdl.teststeps.actions.ShowMessageExchangeAction;
import com.eviware.soapui.support.action.swing.ActionList;


public class RestMockResult extends BaseMockResult<RestMockRequest, RestMockAction> {
    
	public RestMockResult(RestMockRequest request) {
        super(request);
    }
	
	@Override
	public ActionList getActions() {
		
		ActionList actionList = super.getActions();
		if(!mockResultContainsResponse())
			return actionList;
		
		actionList.setDefaultAction(createMessageExchangeAction());
		return actionList;
	}

	private boolean mockResultContainsResponse() {
		return getMockResponse() != null;
	}

	private Action createMessageExchangeAction() {
		return new ShowMessageExchangeAction(createMessageExchange(), "MockResult");
	}

	private RestMockResultMessageExchange createMessageExchange() {
		return new RestMockResultMessageExchange(this);
    }

}
