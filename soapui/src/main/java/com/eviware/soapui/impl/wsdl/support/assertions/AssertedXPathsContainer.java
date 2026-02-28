

package com.eviware.soapui.impl.wsdl.support.assertions;

import com.eviware.soapui.model.testsuite.AssertedXPath;

public interface AssertedXPathsContainer {
    public static final String ASSERTEDXPATHSCONTAINER_PROPERTY = AssertedXPathsContainer.class.getName();

    public void addAssertedXPath(AssertedXPath assertedXPath);
}
