

package com.eviware.soapui.model.mock;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.Releasable;
import com.eviware.soapui.model.iface.Operation;

import java.util.List;

/**
 * A MockOperation for mocking an Interfaces Operation and returning a
 * MockResponse
 *
 * @author ole.matzura
 */

public interface MockOperation extends ModelItem, Releasable {
    public MockService getMockService();

    public int getMockResponseCount();

    public MockResponse getMockResponseAt(int index);

    public MockResponse getMockResponseByName(String name);

    public MockResponse addNewMockResponse(String name);

    public Operation getOperation();

    public MockResult getLastMockResult();

    public List<MockResponse> getMockResponses();

    public void removeMockResponse(MockResponse mockResponse);

    /**
     * This is a container used by dispatcher to save script, xpath expressions etc
     *
     * @return script or xpath
     */
    public String getScript();

    /**
     * @param script this is a String that might be needed by the dispatch style used in this mock operation.
     */
    public void setScript(String script);

    String getScriptHelpUrl();
}
