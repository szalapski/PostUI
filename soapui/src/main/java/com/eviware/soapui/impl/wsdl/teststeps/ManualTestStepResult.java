

package com.eviware.soapui.impl.wsdl.teststeps;

import com.eviware.soapui.support.types.StringList;

public class ManualTestStepResult extends WsdlTestStepResult {
    private StringList urls = new StringList();
    private String result;

    public ManualTestStepResult(ManualTestStep testStep) {
        super(testStep);
    }

    protected StringList getUrls() {
        return urls;
    }

    protected void setUrls(Object[] urls) {
        this.urls.clear();
        for (Object o : urls) {
            this.urls.add(String.valueOf(o));
            addMessage("URL: " + String.valueOf(o));
        }
    }

    protected String getResult() {
        return result;
    }

    protected void setResult(String result) {
        this.result = result;
        super.addMessage(result);
    }
}
