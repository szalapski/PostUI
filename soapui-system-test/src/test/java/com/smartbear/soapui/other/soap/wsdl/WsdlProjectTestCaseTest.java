

package com.smartbear.soapui.other.soap.wsdl;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlImporter;
import com.smartbear.soapui.utils.IntegrationTest;
import com.smartbear.soapui.utils.jetty.JettyTestCaseBase;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

@Category(IntegrationTest.class)
public class WsdlProjectTestCaseTest extends JettyTestCaseBase {

    @Test
    public void testComplexLoad() throws Exception {
        replaceInFile("wsdls/test8/TestService.wsdl", "8082", "" + getPort());
        WsdlProject project = new WsdlProject();
        WsdlInterface[] wsdls = WsdlImporter.importWsdl(project, "http://localhost:" + getPort() + "/wsdls/test8/TestService.wsdl");

        assertEquals(1, wsdls.length);
    }

    @Test
    public void testClasspathLoad() throws Exception {
        String str = SoapUI.class.getResource("/soapui-projects/sample-soapui-project.xml").toURI().toString();

        assertNotNull(new WsdlProject(str));
    }

    public void testInit() throws Exception {
        assertTrue(new WsdlProject().isCacheDefinitions());
    }
}
