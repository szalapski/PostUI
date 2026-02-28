

package com.eviware.soapui.mockaswar;

import com.eviware.soapui.impl.wsdl.mock.DispatchException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

interface MockAsWarCoreInterface {

    public void dispatchRequest(HttpServletRequest request, HttpServletResponse response) throws DispatchException,
            IOException;

    public void stop();

}
