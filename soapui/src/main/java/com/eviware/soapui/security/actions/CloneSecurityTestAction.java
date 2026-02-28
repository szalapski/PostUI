

package com.eviware.soapui.security.actions;

import com.eviware.soapui.security.SecurityTest;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

/**
 * Clones a SecurityTest
 *
 * @author Ole.Matzura
 */

public class CloneSecurityTestAction extends AbstractSoapUIAction<SecurityTest> {
    public CloneSecurityTestAction() {
        super("Clone SecurityTest", "Clones this SecurityTest");
    }

    public void perform(SecurityTest securityTest, Object param) {
        String name = UISupport.prompt("Specify name of cloned SecurityTest", "Clone SecurityTest", "Copy of "
                + securityTest.getName());
        if (StringUtils.isNullOrEmpty(name)) {
            return;
        }

        while (securityTest.getTestCase().getSecurityTestByName(name.trim()) != null) {
            name = UISupport.prompt("Specify unique name of SecurityTest", "Clone SecurityTest", name);
            if (StringUtils.isNullOrEmpty(name)) {
                return;
            }
        }

        SecurityTest newSecurityTest = securityTest.getTestCase().cloneSecurityTest(securityTest, name);
        UISupport.selectAndShow(newSecurityTest);
    }
}
