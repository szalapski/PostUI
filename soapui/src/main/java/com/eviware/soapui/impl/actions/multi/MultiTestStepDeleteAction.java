

package com.eviware.soapui.impl.actions.multi;

import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIMultiAction;

public class MultiTestStepDeleteAction extends AbstractSoapUIMultiAction<ModelItem> {
    public static final String SOAPUI_ACTION_ID = "MultiTestStepDeleteAction";

    public MultiTestStepDeleteAction() {
        super(SOAPUI_ACTION_ID, "Delete TestSteps", "Delete selected TestSteps");
    }

    public void perform(ModelItem[] targets, Object param) {
        if (UISupport.confirm("Delete selected Test Steps?", "Delete Items")) {
            for (ModelItem target : targets) {
                ((WsdlTestStep) target).getTestCase().removeTestStep((WsdlTestStep) target);
            }
        }
    }

    public boolean applies(ModelItem target) {
        return (target instanceof WsdlTestStep);
    }
}
