

package com.eviware.soapui.support;

import com.eviware.soapui.support.xml.XmlObjectConfigurationBuilder;
import com.eviware.soapui.support.xml.XmlObjectConfigurationReader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XmlObjectConfigurationTest {

    @Test
    public void testConfiguration() throws Exception {
        XmlObjectConfigurationBuilder builder = new XmlObjectConfigurationBuilder();
        builder.add("testFloat", (float) 0.123);
        builder.add("testInt", 123);
        builder.add("testString", "1234");

        XmlObjectConfigurationReader reader = new XmlObjectConfigurationReader(builder.finish());
        assertEquals((float) 0.123, reader.readFloat("testFloat", 0), 0);
        assertEquals(123, reader.readInt("testInt", 0));
        assertEquals("1234", reader.readString("testString", null));
    }
}
