

package com.eviware.soapui.impl.wsdl.mock.dispatch;

import com.eviware.soapui.impl.wsdl.mock.DispatchException;
import com.eviware.soapui.model.Releasable;
import com.eviware.soapui.model.mock.MockRequest;
import com.eviware.soapui.model.mock.MockResponse;
import com.eviware.soapui.model.mock.MockResult;

import javax.swing.JComponent;

public interface MockOperationDispatcher extends Releasable {
    public MockResponse selectMockResponse(MockRequest request, MockResult result)
            throws DispatchException;

    public JComponent getEditorComponent();

    public void releaseEditorComponent();

    public boolean hasDefaultResponse();
}
