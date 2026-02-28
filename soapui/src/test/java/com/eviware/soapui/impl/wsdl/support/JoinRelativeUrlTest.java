

package com.eviware.soapui.impl.wsdl.support;

import com.eviware.soapui.support.Tools;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class JoinRelativeUrlTest {

    @Test
    public void testJoin() throws Exception {
        assertEquals("http://test:8080/my/root/test.xsd",
                Tools.joinRelativeUrl("http://test:8080/my/root/test.wsdl", "test.xsd"));
        assertEquals("http://test:8080/my/root/bu/test.xsd",
                Tools.joinRelativeUrl("http://test:8080/my/root/test.wsdl", "bu/test.xsd"));
        assertEquals("http://test:8080/my/test.xsd",
                Tools.joinRelativeUrl("http://test:8080/my/root/test.wsdl", "../test.xsd"));
        assertEquals("http://test:8080/my/root/test.xsd",
                Tools.joinRelativeUrl("http://test:8080/my/root/test.wsdl", "./test.xsd"));
        assertEquals("http://test:8080/bil/test.xsd",
                Tools.joinRelativeUrl("http://test:8080/my/root/test.wsdl", "../../bil/test.xsd"));
        assertEquals("http://test:8080/bil/test.xsd",
                Tools.joinRelativeUrl("http://test:8080/my/root/test.wsdl", "././../../bil/test/.././test.xsd"));
        assertEquals("file:c:" + File.separator + "bil" + File.separator + "xsd" + File.separator + "test.xsd", Tools.joinRelativeUrl("file:c:\\bil\\test.wsdl", "./xsd/test.xsd"));
        assertEquals("file:c:" + File.separator + "bil" + File.separator + "xsd" + File.separator + "test.xsd",
                Tools.joinRelativeUrl("file:c:\\bil\\test\\test\\test.wsdl", "..\\..\\xsd\\test.xsd"));
    }
}
