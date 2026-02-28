

package com.eviware.soapui.model.testsuite;

/**
 * Runner for loadtests
 *
 * @author Ole.Matzura
 */

public interface LoadTestRunner extends TestRunner {
    /**
     * Gets the number of threads currently running
     */

    public int getRunningThreadCount();

    public LoadTest getLoadTest();

    /**
     * Returns the progress of the loadtest as a value between 0 and 1. Progress
     * is measured depending on the LoadTest limit configuration
     */

    public float getProgress();

    /**
     * Confusing but unfortunately necessary; isStopped will return false until
     * the loadtest has called all handlers, etc.. the status will be set to
     * FINISHED before that.
     *
     * @return
     */

    public boolean hasStopped();
}
