

package com.eviware.soapui.impl.wsdl.testcase;

import com.eviware.soapui.model.testsuite.TestStep;

/**
 * Entries in the TestCase Log
 *
 * @author ole.matzura
 */

public class TestCaseLogItem {
    private final TestStep testStep;
    private final String msg;

    public TestCaseLogItem(TestStep testStep, String msg) {
        this.testStep = testStep;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public TestStep getTestStep() {
        return testStep;
    }
}
