

package com.eviware.soapui.impl.wsdl.support.assertions;

import com.eviware.soapui.model.testsuite.AssertedXPath;
import com.eviware.soapui.model.testsuite.TestAssertion;
import org.apache.xmlbeans.XmlObject;

public class AssertedXPathImpl implements AssertedXPath {
    private final TestAssertion assertion;
    private final String path;
    private XmlObject assertedContent;

    public AssertedXPathImpl(TestAssertion assertion, String path, XmlObject assertedContent) {
        this.assertion = assertion;
        this.path = path;
        this.assertedContent = assertedContent;
    }

    public TestAssertion getAssertion() {
        return assertion;
    }

    public String getLabel() {
        return assertion.getName();
    }

    public String getPath() {
        return path;
    }

    public XmlObject getAssertedContent() {
        return assertedContent;
    }

    public void setAssertedContent(XmlObject assertedContent) {
        this.assertedContent = assertedContent;
    }

}
