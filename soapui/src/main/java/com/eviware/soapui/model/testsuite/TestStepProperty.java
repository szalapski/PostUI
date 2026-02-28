

package com.eviware.soapui.model.testsuite;

/**
 * A teststep property, used in teststep/testcase logic
 * <p/>
 * This is left for backward-compatibility reasons
 *
 * @author Ole.Matzura
 */

public interface TestStepProperty extends TestProperty {
    public TestStep getTestStep();
}
