

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.ModelItem;

/**
 * A load-test for a TestCase
 *
 * @author Ole.Matzura
 */

public interface LoadTest extends ModelItem {
    public TestCase getTestCase();

    public LoadTestRunner run();

    public void addLoadTestRunListener(LoadTestRunListener listener);

    public void removeLoadTestRunListener(LoadTestRunListener listener);
}
