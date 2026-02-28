

package com.eviware.soapui.security.actions;

import com.eviware.soapui.security.SecurityTest;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Renames a SecurityTest
 *
 * @author Ole.Matzura
 */

public class RenameSecurityTestAction extends AbstractSoapUIAction<SecurityTest> {
    public RenameSecurityTestAction() {
        super("Rename", "Renames this SecurityTest");
    }

    public void perform(SecurityTest securityTest, Object param) {
        String name = UISupport.prompt("Specify name of SecurityTest", "Rename SecurityTest", securityTest.getName());
        if (StringUtils.isNullOrEmpty(name) || name.equals(securityTest.getName())) {
            return;
        }

        while (securityTest.getTestCase().getSecurityTestByName(name.trim()) != null) {
            name = UISupport.prompt("Specify unique name of SecurityTest", "Rename SecurityTest", securityTest.getName());
            if (StringUtils.isNullOrEmpty(name) || name.equals(securityTest.getName())) {
                return;
            }
        }

        securityTest.setName(name);
    }
}
