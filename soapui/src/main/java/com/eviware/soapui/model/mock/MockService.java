

package com.eviware.soapui.model.mock;

import com.eviware.soapui.impl.support.HasHelpUrl;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.Releasable;
import com.eviware.soapui.model.TestModelItem;
import com.eviware.soapui.model.iface.Operation;
import com.eviware.soapui.model.support.AnimatableItem;

import java.util.List;

/**
 * ModelItem for mocking a number of Interfaces and their Operations
 *
 * @author ole.matzura
 */

public interface MockService extends TestModelItem, Releasable, AnimatableItem, HasHelpUrl, MockServer, MockServiceScripts
{
    public final static String PATH_PROPERTY = MockService.class.getName() + "@path";
    public final static String PORT_PROPERTY = MockService.class.getName() + "@port";

    public WsdlProject getProject();

    public List<MockOperation> getMockOperationList();

    public int getMockOperationCount();

    public MockOperation getMockOperationAt(int index);

    public MockOperation getMockOperationByName(String name);

    public MockOperation addNewMockOperation(Operation operation);

    public void removeMockOperation(MockOperation mockOperation);

    public void addMockServiceListener(MockServiceListener listener);

    public void removeMockServiceListener(MockServiceListener listener);

    public void fireMockOperationAdded(MockOperation mockOperation);

    public void fireMockOperationRemoved(MockOperation mockOperation);

    public void fireMockResponseAdded(MockResponse mockResponse);

    public void fireMockResponseRemoved(MockResponse mockResponse);

    public String getStringID();
}
