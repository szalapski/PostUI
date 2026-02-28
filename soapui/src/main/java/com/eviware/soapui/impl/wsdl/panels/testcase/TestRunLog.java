

package com.eviware.soapui.impl.wsdl.panels.testcase;

import com.eviware.soapui.model.testsuite.TestStepResult;

import java.io.PrintWriter;

public interface TestRunLog {
    public void clear();

    public void addText(String string);

    public void addTestStepResult(TestStepResult stepResult);

    public void addBoldText(String string);

    public void release();

    public void printLog(PrintWriter out);
}
