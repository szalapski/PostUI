

package com.eviware.soapui.impl.wsdl;

import com.eviware.soapui.impl.wsdl.support.PathUtils;
import com.eviware.soapui.support.Tools;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class ResolveContextTest {

    @Test
    public void shouldRelativizePath() {
        assertTrue(testFilePath("test.txt", "c:" + File.separator + "dir" + File.separator + "test.txt", "c:" + File.separator + "dir"));
        assertTrue(testFilePath("dir2" + File.separator + "test.txt", "c:" + File.separator + "dir" + File.separator + "dir2" + File.separator + "test.txt", "c:" + File.separator + "dir"));
        assertTrue(testFilePath(".." + File.separator + "test.txt", "c:" + File.separator + "dir" + File.separator + "dir2" + File.separator + "test.txt", "c:" + File.separator + "dir" + File.separator + "dir2" + File.separator + "dir3"));
        assertTrue(testFilePath("dir" + File.separator + "test.txt", "c:" + File.separator + "dir" + File.separator + "test.txt", "c:" + File.separator + ""));
        assertTrue(testFilePath(".." + File.separator + "test.txt", "c:" + File.separator + "dir" + File.separator + "test.txt", "c:" + File.separator + "dir" + File.separator + "anotherDir"));
        assertTrue(testFilePath(".." + File.separator + "dir2" + File.separator + "test.txt", "c:" + File.separator + "dir" + File.separator + "dir2" + File.separator + "test.txt", "c:" + File.separator + "dir" + File.separator + "anotherDir"));

        testUrl("test.txt", "http://www.test.com/dir/test.txt", "http://www.test.com/dir");
        testUrl("dir2/test.txt", "http://www.test.com/dir/dir2/test.txt", "http://www.test.com/dir");
        testUrl("../test.txt?test", "http://www.test.com/dir/dir2/test.txt?test", "http://www.test.com/dir/dir2/dir3");
    }

    private boolean testFilePath(String relativePath, String absolutePath, String rootPath) {
        Boolean rValue = relativePath.equals(PathUtils.relativize(absolutePath, rootPath));

        if (!rValue) {
            return rValue;
        }

        if (!rootPath.endsWith(File.separator)) {
            rootPath += File.separator;
        }

        rValue = absolutePath.equals(Tools.joinRelativeUrl(rootPath, relativePath));

        return rValue;
    }

    private boolean testUrl(String relativePath, String absolutePath, String rootPath) {
        Boolean rValue = relativePath.equals(PathUtils.relativize(absolutePath, rootPath));

        if (!rValue) {
            return rValue;
        }

        if (!rootPath.endsWith("/")) {
            rootPath += "/";
        }

        rValue = absolutePath.equals(Tools.joinRelativeUrl(rootPath, relativePath));

        return rValue;
    }
}
