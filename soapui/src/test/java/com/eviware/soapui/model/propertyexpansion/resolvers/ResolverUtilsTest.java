

package com.eviware.soapui.model.propertyexpansion.resolvers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResolverUtilsTest {

    @Test
    public void testExtractXPathPropertyValue() throws Exception {
        assertEquals("audi", ResolverUtils.extractXPathPropertyValue("<test><bil>audi</bil></test>", "//bil"));
        assertEquals("<test><bil>audi</bil><bil>bmw</bil></test>",
                ResolverUtils.extractXPathPropertyValue("<test><bil>audi</bil><bil>bmw</bil></test>", "//test"));
        assertEquals("audi",
                ResolverUtils.extractXPathPropertyValue("<test><bil>audi</bil><bil>bmw</bil></test>", "//test/bil[1]"));
    }
}
