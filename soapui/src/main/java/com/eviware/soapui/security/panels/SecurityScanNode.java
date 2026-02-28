

package com.eviware.soapui.security.panels;

import com.eviware.soapui.model.security.SecurityScan;

import javax.swing.tree.DefaultMutableTreeNode;

public class SecurityScanNode extends DefaultMutableTreeNode {

    private SecurityScan securityCheck;

    public SecurityScanNode(SecurityScan sc) {
        this.securityCheck = sc;
    }

    @Override
    public String toString() {
        return securityCheck.toString();
    }

    public SecurityScan getSecurityScan() {
        return securityCheck;
    }
}
