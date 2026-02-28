

package com.eviware.soapui.model.testsuite;

import org.apache.xmlbeans.XmlObject;

/**
 * Returns an xpath that has been asserted during a test-run..
 *
 * @author Ole Matzura
 */

public interface AssertedXPath {
    public TestAssertion getAssertion();

    public String getPath();

    public String getLabel();

    public XmlObject getAssertedContent();
}
