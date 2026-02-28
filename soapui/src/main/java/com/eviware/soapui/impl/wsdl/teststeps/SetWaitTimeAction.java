

package com.eviware.soapui.impl.wsdl.teststeps;

import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Sets the delay to of a WsdlDelayTestStep
 *
 * @author ole.matzura
 */

public class SetWaitTimeAction extends AbstractSoapUIAction<WsdlDelayTestStep> {
    public SetWaitTimeAction() {
        super("Set Delay Time", "Sets the Delay for this DelayStep");
    }

    public void perform(WsdlDelayTestStep target, Object param) {
        String value = UISupport.prompt("Specify delay in milliseconds", "Set Delay",
                String.valueOf(target.getDelayString()));
        if (value != null) {
            try {
                target.setDelayString(value);
            } catch (NumberFormatException e1) {
                UISupport.showErrorMessage(e1);
            }
        }
    }
}
