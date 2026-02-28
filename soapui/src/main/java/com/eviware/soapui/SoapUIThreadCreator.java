

package com.eviware.soapui;

import java.util.concurrent.ThreadFactory;

/**
 * Creates threads for SoapUI internal usage that have the extensionClassLoader
 * as parent
 *
 * @author Ole
 */

public class SoapUIThreadCreator implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setContextClassLoader(SoapUI.getSoapUICore().getExtensionClassLoader());
        return thread;
    }
}
