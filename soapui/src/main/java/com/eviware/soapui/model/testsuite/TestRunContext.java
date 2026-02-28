

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.iface.SubmitContext;
import com.eviware.soapui.model.propertyexpansion.PropertyExpansionContext;

public interface TestRunContext extends SubmitContext, PropertyExpansionContext {
    public final static String LOAD_TEST_RUNNER = "LoadTestRunner";
    public static final String THREAD_INDEX = "ThreadIndex";
    public static final String RUN_COUNT = "RunCount";
    public static final String TOTAL_RUN_COUNT = "TotalRunCount";
    public static final String LOAD_TEST_CONTEXT = "LoadTestContext";
    public static final String INTERACTIVE = "Interactive";

    public String expand(String content);

    public TestRunner getTestRunner();
}
