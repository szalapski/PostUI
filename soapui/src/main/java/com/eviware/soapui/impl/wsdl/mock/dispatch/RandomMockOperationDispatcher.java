

package com.eviware.soapui.impl.wsdl.mock.dispatch;

import com.eviware.soapui.model.mock.MockOperation;
import com.eviware.soapui.model.mock.MockRequest;
import com.eviware.soapui.model.mock.MockResponse;
import com.eviware.soapui.model.mock.MockResult;

public class RandomMockOperationDispatcher extends AbstractMockOperationDispatcher {
    public RandomMockOperationDispatcher(MockOperation mockOperation) {
        super(mockOperation);
    }

    public MockResponse selectMockResponse(MockRequest request, MockResult result) {
        synchronized (result.getMockOperation()) {
            synchronized (this) {
                int currentDispatchIndex = (int) ((Math.random() * getMockOperation().getMockResponseCount()) + 0.5F);

                if (currentDispatchIndex >= getMockOperation().getMockResponseCount()) {
                    currentDispatchIndex = 0;
                }

                return getMockOperation().getMockResponseAt(currentDispatchIndex);
            }
        }
    }

    @Override
    public boolean hasDefaultResponse() {
        return false;
    }

    public static class Factory implements MockOperationDispatchFactory {
        public MockOperationDispatcher build(MockOperation mockOperation) {
            return new RandomMockOperationDispatcher(mockOperation);
        }
    }
}
