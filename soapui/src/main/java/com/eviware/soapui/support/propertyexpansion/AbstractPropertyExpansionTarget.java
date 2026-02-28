

package com.eviware.soapui.support.propertyexpansion;

import com.eviware.soapui.impl.wsdl.teststeps.HttpTestRequestInterface;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequest;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.propertyexpansion.PropertyExpansion;
import com.eviware.soapui.support.scripting.SoapUIScriptEngineRegistry;
import com.eviware.soapui.support.scripting.SoapUIScriptGenerator;

public abstract class AbstractPropertyExpansionTarget implements PropertyExpansionTarget {
    private ModelItem modelItem;

    public AbstractPropertyExpansionTarget(ModelItem modelItem) {
        this.modelItem = modelItem;
    }

    public ModelItem getContextModelItem() {
        if (modelItem instanceof WsdlTestRequest) {
            modelItem = ((WsdlTestRequest) modelItem).getTestStep();
        } else if (modelItem instanceof HttpTestRequestInterface<?>) {
            modelItem = ((HttpTestRequestInterface<?>) modelItem).getTestStep();
        }

        return modelItem;
    }

    public ModelItem getModelItem() {
        return modelItem;
    }

    protected String createContextExpansion(String name, PropertyExpansion expansion) {
        SoapUIScriptGenerator scriptGenerator = SoapUIScriptEngineRegistry.createScriptGenerator(getModelItem());
        return scriptGenerator.createContextExpansion(name, expansion);
    }
}
