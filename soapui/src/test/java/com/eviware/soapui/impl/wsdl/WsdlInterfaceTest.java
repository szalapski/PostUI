

package com.eviware.soapui.impl.wsdl;

import com.eviware.soapui.config.WsdlInterfaceConfig;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WsdlInterfaceTest {

    private WsdlProject project;
    private WsdlInterfaceConfig interfaceConfig;
    private WsdlInterface iface;

    @Before
    public void setUp() throws Exception {
        project = new WsdlProject();
        interfaceConfig = WsdlInterfaceConfig.Factory.newInstance();
        iface = new WsdlInterface(project, interfaceConfig);

        assertEquals(0, iface.getEndpoints().length);
    }

    @Test
    public void testAddEndpoints() throws Exception {
        iface.addEndpoint("testEndpoint");
        assertEquals(1, iface.getEndpoints().length);
        assertEquals("testEndpoint", iface.getEndpoints()[0]);

        iface.addEndpoint("testEndpoint");
        assertEquals(1, iface.getEndpoints().length);
        assertEquals("testEndpoint", iface.getEndpoints()[0]);

        iface.addEndpoint("testEndpoint2");
        assertEquals(2, iface.getEndpoints().length);
        assertEquals("testEndpoint", iface.getEndpoints()[0]);
        assertEquals("testEndpoint2", iface.getEndpoints()[1]);
    }

    @Test
    public void testRemoveEndpoints() throws Exception {
        iface.addEndpoint("testEndpoint");
        iface.addEndpoint("testEndpoint2");

        iface.removeEndpoint("testEndpoint");
        assertEquals(1, iface.getEndpoints().length);

        iface.removeEndpoint("testEndpoint2");
        assertEquals(0, iface.getEndpoints().length);
    }
}
