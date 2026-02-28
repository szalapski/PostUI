

package com.eviware.soapui.impl.wsdl;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AttachmentTest {

    @Test
    public void shouldHaveAttachments() throws Exception {

        String wsdlUrl = AttachmentTest.class.getResource("/attachment-test.wsdl").toString();
        WsdlProject project = new WsdlProject();
        WsdlInterface iface = WsdlInterfaceFactory.importWsdl(project, wsdlUrl, false)[0];

        WsdlOperation operation = iface.getOperationByName("SendClaim");
        WsdlRequest request = operation.addNewRequest("Test");

        request.setRequestContent(operation.createRequest(true));

        System.out.println(request.getRequestContent());

        HttpAttachmentPart[] definedAttachmentParts = request.getDefinedAttachmentParts();

        assertEquals(definedAttachmentParts.length, 4);
        assertEquals(definedAttachmentParts[0].getName(), "ClaimPhoto");
    }
}
