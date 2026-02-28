

package com.eviware.soapui.support;

import com.eviware.soapui.SoapUI;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;

public class ClasspathHacker {
    private static void addFile(String s) throws IOException {
        File f = new File(s);
        addFile(f);
    }// end method

    private static void addFile(File f) throws IOException {
        addURL(f.toURI().toURL());
    }// end method

    private static void addURL(URL u) throws IOException {
        ClassLoader classLoader = SoapUI.class.getClassLoader();

        addUrlToClassLoader(u, classLoader);

    }// end method

    private static void addUrlToClassLoader(URL u, ClassLoader classLoader) throws IOException {
        try {
            Method method = classLoader.getClass().getDeclaredMethod("addURL", new Class[]{java.net.URL.class});
            method.setAccessible(true);
            method.invoke(classLoader, new Object[]{u});

            SoapUI.log.info("Added [" + u.toString() + "] to classpath");
        } catch (NoSuchMethodException e) {
            try {
                Method method = classLoader.getClass().getSuperclass()
                        .getDeclaredMethod("addURL", new Class[]{java.net.URL.class});
                method.setAccessible(true);
                method.invoke(classLoader, new Object[]{u});

                SoapUI.log.info("Added [" + u.toString() + "] to classpath");
            } catch (NoSuchMethodException ex) {
                try {
                    Method method = classLoader.getClass().getSuperclass().getSuperclass()
                            .getDeclaredMethod("addURL", new Class[]{java.net.URL.class});
                    method.setAccessible(true);
                    method.invoke(classLoader, new Object[]{u});

                    SoapUI.log.info("Added [" + u.toString() + "] to classpath");
                } catch (Throwable t) {
                    try {
                        if (classLoader.getParent() != null) {
                            SoapUI.log.info("Failed to add jar to " + classLoader.getClass().getName() + ", trying parent");
                            addUrlToClassLoader(u, classLoader.getParent());
                        } else {
                            throw new IOException("Error, could not add URL to classloader "
                                    + classLoader.getClass().getName());
                        }
                    } catch (IOException e3) {
                        SoapUI.logError(t);
                        throw e3;
                    }
                }// end try catch
            } catch (Throwable t) {
                SoapUI.logError(t);
                throw new IOException("Error, could not add URL to system classloader " + classLoader.getClass().getName());
            }// end try catch
        } catch (Throwable t) {
            SoapUI.logError(t);
            throw new IOException("Error, could not add URL to system classloader " + classLoader.getClass().getName());
        }// end try catch
    }

}// end class
