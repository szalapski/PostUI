

package com.eviware.soapui.impl.wsdl.teststeps;

import com.eviware.soapui.config.TestStepConfig;
import com.eviware.soapui.impl.support.http.HttpRequestTestStep;
import com.eviware.soapui.impl.wsdl.AbstractWsdlModelItem;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.propertyexpansion.PropertyExpansionContainer;
import com.eviware.soapui.model.testsuite.Assertable;
import com.eviware.soapui.support.resolver.ResolveContext;

import java.beans.PropertyChangeListener;

public interface HttpTestRequestStepInterface extends PropertyChangeListener, PropertyExpansionContainer, Assertable,
        HttpRequestTestStep, ModelItem {
    public WsdlTestStep clone(WsdlTestCase targetTestCase, String name);

    public void release();

    public void resetConfigOnMove(TestStepConfig config);

    public HttpTestRequestInterface<?> getTestRequest();

    public void setName(String name);

    public boolean dependsOn(AbstractWsdlModelItem<?> modelItem);

    public void beforeSave();

    public void setDescription(String description);

    public String getDefaultSourcePropertyName();

    public String getDefaultTargetPropertyName();

    public void resolve(ResolveContext<?> context);

    public WsdlTestCase getTestCase();
}
