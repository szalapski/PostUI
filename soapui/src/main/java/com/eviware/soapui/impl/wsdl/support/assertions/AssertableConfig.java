

package com.eviware.soapui.impl.wsdl.support.assertions;

import com.eviware.soapui.config.TestAssertionConfig;

import java.util.List;

public interface AssertableConfig {
    List<TestAssertionConfig> getAssertionList();

    void removeAssertion(int ix);

    TestAssertionConfig addNewAssertion();

    TestAssertionConfig insertAssertion(TestAssertionConfig newAssertion, int ix);
}
