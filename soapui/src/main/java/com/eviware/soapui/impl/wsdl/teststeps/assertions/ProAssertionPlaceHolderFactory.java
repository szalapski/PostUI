

package com.eviware.soapui.impl.wsdl.teststeps.assertions;

import com.eviware.soapui.config.TestAssertionConfig;
import com.eviware.soapui.impl.wsdl.panels.assertions.AssertionListEntry;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlMessageAssertion;
import com.eviware.soapui.model.TestPropertyHolder;
import com.eviware.soapui.model.iface.MessageExchange;
import com.eviware.soapui.model.iface.SubmitContext;
import com.eviware.soapui.model.testsuite.Assertable;
import com.eviware.soapui.model.testsuite.Assertable.AssertionStatus;
import com.eviware.soapui.model.testsuite.AssertionException;
import com.eviware.soapui.model.testsuite.TestAssertion;

public class ProAssertionPlaceHolderFactory implements TestAssertionFactory {

    private String type;

    public ProAssertionPlaceHolderFactory(String type, String string2) {
        this.type = type;
    }

    @Override
    public boolean canAssert(Assertable assertable) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canAssert(TestPropertyHolder modelItem, String property) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public TestAssertion buildAssertion(TestAssertionConfig config, Assertable assertable) {
        return new ProAssertionPlaceHolder(config, assertable);
    }

    @Override
    public Class<? extends WsdlMessageAssertion> getAssertionClassType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getAssertionId() {
        return type;
    }

    @Override
    public String getAssertionLabel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AssertionListEntry getAssertionListEntry() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getCategory() {
        // TODO Auto-generated method stub
        return null;
    }

    private class ProAssertionPlaceHolder extends WsdlMessageAssertion {

        protected ProAssertionPlaceHolder(TestAssertionConfig assertionConfig, Assertable modelItem, boolean cloneable,
                                          boolean configurable, boolean multiple, boolean requiresResponseContent) {
            super(assertionConfig, modelItem, cloneable, configurable, multiple, requiresResponseContent);
        }

        public ProAssertionPlaceHolder(TestAssertionConfig config, Assertable assertable) {
            this(config, assertable, false, false, false, false);
        }

        @Override
        protected String internalAssertResponse(MessageExchange messageExchange, SubmitContext context)
                throws AssertionException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        protected String internalAssertRequest(MessageExchange messageExchange, SubmitContext context)
                throws AssertionException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        protected String internalAssertProperty(TestPropertyHolder source, String propertyName,
                                                MessageExchange messageExchange, SubmitContext context) throws AssertionException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public AssertionStatus getStatus() {
            return assertionStatus.UNKNOWN;
        }

        @Override
        public boolean isDisabled() {
            return true;
        }
    }
}
