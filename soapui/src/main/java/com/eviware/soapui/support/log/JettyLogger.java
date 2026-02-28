

package com.eviware.soapui.support.log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;
import org.mortbay.log.Logger;

/**
 * Logger for Jetty Events
 *
 * @author ole.matzura
 */

public class JettyLogger implements Logger {
    org.apache.logging.log4j.Logger log = LogManager.getLogger("jetty");

    public void debug(String arg0, Throwable arg1) {
        log.debug(arg0, arg1);
    }

    public void debug(String arg0, Object arg1, Object arg2) {
        log.debug(format(arg0, arg1, arg2));
    }

    public Logger getLogger(String arg0) {
        System.out.println("Ignoring request for logger [" + arg0 + "]");
        return this;
    }

    public void info(String arg0, Object arg1, Object arg2) {
        log.info(format(arg0, arg1, arg2));
    }

    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    public void setDebugEnabled(boolean arg0) {
        Configurator.setLevel(log.getName(), Level.DEBUG);
    }

    public void warn(String arg0, Throwable arg1) {
        log.warn(arg0, arg1);

    }

    public void warn(String arg0, Object arg1, Object arg2) {
        log.warn(format(arg0, arg1, arg2));
    }

    private String format(String msg, Object arg0, Object arg1) {
        int i0 = msg.indexOf("{}");
        int i1 = i0 < 0 ? -1 : msg.indexOf("{}", i0 + 2);

        if (arg1 != null && i1 >= 0) {
            msg = msg.substring(0, i1) + arg1 + msg.substring(i1 + 2);
        }
        if (arg0 != null && i0 >= 0) {
            msg = msg.substring(0, i0) + arg0 + msg.substring(i0 + 2);
        }
        return msg;
    }
}
