

package com.eviware.soapui.utils;

import java.net.URISyntaxException;

public class ResourceUtils {

    public static String getFilePathFromResource(String fileName) throws URISyntaxException {
        return ResourceUtils.class.getResource(fileName).getFile();
    }
}
