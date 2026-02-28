

package com.eviware.soapui.impl.wsdl.teststeps.assertions;

import com.eviware.soapui.config.TestAssertionConfig;
import com.eviware.soapui.impl.wsdl.panels.assertions.AssertionListEntry;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlMessageAssertion;
import com.eviware.soapui.model.TestPropertyHolder;
import com.eviware.soapui.model.testsuite.Assertable;
import com.eviware.soapui.model.testsuite.TestAssertion;

public interface TestAssertionFactory {
    public boolean canAssert(Assertable assertable);

    public boolean canAssert(TestPropertyHolder modelItem, String property);

    public TestAssertion buildAssertion(TestAssertionConfig config, Assertable assertable);

    public Class<? extends WsdlMessageAssertion> getAssertionClassType();

    public String getAssertionId();

    public String getAssertionLabel();

    public AssertionListEntry getAssertionListEntry();

    public String getCategory();
}
