

package com.eviware.soapui.impl.wsdl.support;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.support.wsdl.UrlWsdlLoader;
import com.eviware.soapui.impl.wsdl.support.xsd.SchemaUtils;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SchemaUtilsDefaultNSTest {

    @Test
    public void testLoadNS() throws Exception {
        SoapUI.initDefaultCore();
        String wsdlUriString = SchemaUtilsDefaultNSTest.class.getResource("/chameleon/chameleon.wsdl").toString();
        SchemaTypeSystem sts = SchemaUtils.loadSchemaTypes(wsdlUriString, new UrlWsdlLoader(wsdlUriString));
        assertNotNull(sts);
    }
}
