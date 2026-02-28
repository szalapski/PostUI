

package com.eviware.soapui.tools;

import java.io.File;

/**
 * @author joel.jonsson
 */
public class JfxrtLocator {
    public static void main(String[] args) {
        String javaHome = System.getProperty("java.home");
        File jfxrtFile = new File(new File(javaHome, "lib"), "jfxrt.jar");
        System.out.println(jfxrtFile.getAbsolutePath());
    }
}
