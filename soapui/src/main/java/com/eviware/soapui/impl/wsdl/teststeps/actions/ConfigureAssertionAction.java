

package com.eviware.soapui.impl.wsdl.teststeps.actions;

import com.eviware.soapui.impl.wsdl.teststeps.WsdlMessageAssertion;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Configures the specified WsdlMessageAssertion
 *
 * @author ole.matzura
 */

public class ConfigureAssertionAction extends AbstractSoapUIAction<WsdlMessageAssertion> {
    public static final String SOAPUI_ACTION_ID = "ConfigureAssertionAction";

    public ConfigureAssertionAction() {
        super("Configure", "Configures this assertion");
    }

    public void perform(WsdlMessageAssertion target, Object param) {
        target.configure();
    }
}
