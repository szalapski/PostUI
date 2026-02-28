

package com.eviware.soapui.impl.wsdl.support;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathUtilsTest {


    @Test
    public void relativizesPaths() throws Exception {
        assertEquals("c:\\test\\file.txt", PathUtils.relativize("c:\\test\\file.txt", "d:\\"));
        assertEquals("c:/test/file.txt", PathUtils.relativize("c:/test/file.txt", "d:\\"));
        assertEquals("c:\\test\\file.txt", PathUtils.relativize("c:\\test\\file.txt", "d:/"));
    }
}
