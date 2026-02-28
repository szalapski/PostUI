

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.support.action.swing.ActionList;

import java.io.PrintWriter;

/**
 * A TestStep result
 *
 * @author Ole.Matzura
 */

public interface TestStepResult {
    public enum TestStepStatus {
        UNKNOWN, OK, FAILED, CANCELED
    }

    public TestStepStatus getStatus();

    public TestStep getTestStep();

    /**
     * Returns a list of actions that can be applied to this result
     */

    public ActionList getActions();

    public String[] getMessages();

    public Throwable getError();

    public long getTimeTaken();

    public long getTimeStamp();

    /**
     * Used for calculating throughput
     *
     * @return the number of bytes in this result
     */

    public long getSize();

    /**
     * Writes this result to the specified writer, used for logging.
     */

    public void writeTo(PrintWriter writer);

    /**
     * Can discard any result data that may be taking up memory. Timing-values
     * must not be discarded.
     */

    public void discard();

    public boolean isDiscarded();
}
