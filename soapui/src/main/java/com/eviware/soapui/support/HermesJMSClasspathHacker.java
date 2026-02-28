

package com.eviware.soapui.support;

import hermes.HermesLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HermesJMSClasspathHacker {
    private static void addFile(String s) throws IOException {
        File f = new File(s);
        addFile(f);
    }// end method

    private static void addFile(File f) throws IOException {
        addURL(f.toURI().toURL());
    }// end method

    private static void addURL(URL u) throws IOException {
        ClassLoader classLoader = HermesLoader.class.getClassLoader();
        // ClasspathHacker.addUrlToClassLoader( u, classLoader );
    }// end method

}// end class
