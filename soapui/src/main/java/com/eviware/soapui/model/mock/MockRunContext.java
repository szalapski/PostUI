

package com.eviware.soapui.model.mock;

import com.eviware.soapui.model.propertyexpansion.PropertyExpansionContext;
import com.eviware.soapui.support.types.StringToStringMap;

/**
 * Context available for the duration of a MockServices execution
 *
 * @author ole.matzura
 */

public interface MockRunContext extends PropertyExpansionContext {
    public MockService getMockService();

    public MockResponse getMockResponse();

    public MockRunner getMockRunner();

    public void setMockResponse(MockResponse mockResponse);

    public StringToStringMap toStringToStringMap();
}
