

package com.eviware.soapui.model.support;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.mock.WsdlMockOperation;
import com.eviware.soapui.impl.wsdl.mock.WsdlMockResponse;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlMockResponseTestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.iface.Operation;
import com.eviware.soapui.model.testsuite.TestProperty;
import org.apache.commons.beanutils.PropertyUtils;

public class XPathReferenceImpl implements XPathReference {
    private String label;
    private Object target;
    private String xpathPropertyName;
    private String xpath;
    private Operation operation;
    private boolean request;

    public XPathReferenceImpl(String label, Operation operation, boolean request, Object target,
                              String xpathPropertyName) {
        this.label = label;
        this.operation = operation;
        this.request = request;
        this.target = target;
        this.xpathPropertyName = xpathPropertyName;

        try {
            this.xpath = (String) PropertyUtils.getProperty(target, xpathPropertyName);
        } catch (Exception e) {
            SoapUI.logError(e);
        }
    }

    public XPathReferenceImpl(String label, TestProperty property, Object target, String xpathPropertyName) {
        this.label = label;
        this.target = target;
        this.xpathPropertyName = xpathPropertyName;

        ModelItem modelItem = property == null ? null : property.getModelItem();

        if (modelItem instanceof WsdlTestRequestStep) {
            operation = ((WsdlTestRequestStep) modelItem).getTestRequest().getOperation();
            request = property.getName().equalsIgnoreCase("Request");
        } else if (modelItem instanceof WsdlMockResponseTestStep) {
            operation = ((WsdlMockResponseTestStep) modelItem).getOperation();
            request = property.getName().equalsIgnoreCase("Request");
        } else if (modelItem instanceof WsdlMockResponse) {
            operation = ((WsdlMockResponse) modelItem).getMockOperation().getOperation();
            request = property.getName().equalsIgnoreCase("Request");
        } else if (modelItem instanceof WsdlMockOperation) {
            operation = ((WsdlMockOperation) modelItem).getOperation();
            request = property.getName().equalsIgnoreCase("Request");
        }
        try {
            this.xpath = (String) PropertyUtils.getProperty(target, xpathPropertyName);
        } catch (Exception e) {
            SoapUI.logError(e);
        }
    }

    public String getLabel() {
        return label;
    }

    public String getXPath() {
        return xpath;
    }

    public void setXPath(String xpath) {
        this.xpath = xpath;
    }

    public void update() {
        try {
            PropertyUtils.setProperty(target, xpathPropertyName, xpath);
        } catch (Exception e) {
            SoapUI.logError(e);
        }
    }

    public Operation getOperation() {
        return operation;
    }

    public boolean isRequest() {
        return request;
    }

}
