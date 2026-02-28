

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.testsuite.Assertable.AssertionStatus;

public interface TestAssertion extends ModelItem {
    public final static String DISABLED_PROPERTY = TestAssertion.class.getName() + "@disabled";
    public final static String STATUS_PROPERTY = TestAssertion.class.getName() + "@status";
    public final static String ERRORS_PROPERTY = TestAssertion.class.getName() + "@errors";
    public final static String CONFIGURATION_PROPERTY = TestAssertion.class.getName() + "@configuration";

    public AssertionStatus getStatus();

    public AssertionError[] getErrors();

    public boolean isAllowMultiple();

    public boolean isConfigurable();

    public boolean isClonable();

    public boolean configure();

    public Assertable getAssertable();

    public String getLabel();

    public boolean isDisabled();

    public void prepare(TestCaseRunner testRunner, TestCaseRunContext testRunContext) throws Exception;

    public int getIndexOfAssertion(TestAssertion assertion);
}
