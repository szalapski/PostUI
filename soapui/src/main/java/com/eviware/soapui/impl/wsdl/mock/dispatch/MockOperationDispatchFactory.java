

package com.eviware.soapui.impl.wsdl.mock.dispatch;

import com.eviware.soapui.model.mock.MockOperation;

public interface MockOperationDispatchFactory {
    MockOperationDispatcher build(MockOperation mockOperation);
}
