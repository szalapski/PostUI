

package com.eviware.soapui.impl.wsdl.panels.mockoperation;

import com.eviware.soapui.impl.wsdl.mock.WsdlMockResponse;

/**
 * DesktopPanel for WsdlMockResponse
 *
 * @author ole.matzura
 */

public class WsdlMockResponseDesktopPanel extends AbstractWsdlMockResponseDesktopPanel<WsdlMockResponse> {
    public WsdlMockResponseDesktopPanel(WsdlMockResponse mockResponse) {
        super(mockResponse);

        init(mockResponse);
    }
}
