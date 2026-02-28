

package com.smartbear.soapui.other.soap.wsdl;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.*;
import com.eviware.soapui.model.iface.Response;
import com.smartbear.soapui.utils.IntegrationTest;
import com.smartbear.soapui.utils.jetty.JettyTestCaseBase;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertNotNull;

@Category(IntegrationTest.class)
public class WsdlRequestTestCaseTest extends JettyTestCaseBase {

    @Test
    public void testRequest() throws Exception {
        replaceInFile("wsdls/test1/TestService.wsdl", "8082", "" + getPort());
        replaceInFile("wsdls/test1/TestService.wsdl", "www.eviware.com", "localhost:" + getPort());

        // create new project
        WsdlProject project = new WsdlProject();

        // import amazon wsdl
        WsdlInterface iface = WsdlInterfaceFactory.importWsdl(project, "http://localhost:" + getPort() + "/wsdls/test1/TestService.wsdl",
                true)[0];

        // get "Help" operation
        WsdlOperation operation = (WsdlOperation) iface.getOperationByName("GetPage");

        // create a new empty request for that operation
        WsdlRequest request = operation.addNewRequest("My request");

        // generate the request content from the schema
        request.setRequestContent(operation.createRequest(true));

        // submit the request
        WsdlSubmit submit = (WsdlSubmit) request.submit(new WsdlSubmitContext(request), false);

        // wait for the response
        Response response = submit.getResponse();

        // print the response
        String content = response.getContentAsString();
        // System.out.println( content );
        assertNotNull(content);
    }
}