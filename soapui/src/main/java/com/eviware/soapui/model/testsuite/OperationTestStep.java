

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.iface.Operation;

/**
 * A TestStep in a TestCase
 *
 * @author Ole.Matzura
 */

public interface OperationTestStep extends TestStep, ResultContainer {
    public Operation getOperation();
}
