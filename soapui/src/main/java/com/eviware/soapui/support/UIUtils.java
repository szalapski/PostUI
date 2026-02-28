

package com.eviware.soapui.support;

public interface UIUtils {
    void invokeLater(Runnable runnable);

    void invokeAndWait(Runnable runnable) throws Exception;

    void runInUIThreadIfSWT(Runnable runnable);

    void invokeAndWaitIfNotInEDT(Runnable runnable);
}
