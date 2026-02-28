

package com.eviware.soapui.support.swing;

import com.eviware.soapui.support.UIUtils;

import javax.swing.SwingUtilities;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Lars Höidahl
 */
public class SwingUtils implements UIUtils {
    public void invokeLater(Runnable runnable) {
        SwingUtilities.invokeLater(runnable);
    }

    public void invokeAndWait(Runnable runnable) throws Exception {
        SwingUtilities.invokeAndWait(runnable);
    }

    // TODO Change this to run in the UI thread on Swing too, and then rename the
    // function to "runInUIThread".
    public void runInUIThreadIfSWT(Runnable runnable) {
        runnable.run();
    }

    @Override
    public void invokeAndWaitIfNotInEDT(Runnable runnable) {
        if (SwingUtilities.isEventDispatchThread()) {
            runnable.run();
        } else {
            try {
                SwingUtilities.invokeAndWait(runnable);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
