

package com.eviware.soapui.security.registry;

import com.eviware.soapui.config.SecurityScanConfig;
import com.eviware.soapui.impl.wsdl.teststeps.RestTestRequestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.security.scan.AbstractSecurityScan;
import com.eviware.soapui.security.scan.BoundarySecurityScan;

/**
 * Factory for creation Boundary scans
 *
 * @author nebojsa.tasic
 */

public class BoundarySecurityScanFactory extends AbstractSecurityScanFactory {

    public BoundarySecurityScanFactory() {
        super(BoundarySecurityScan.TYPE, BoundarySecurityScan.NAME, "Executes the specified boundary security scan",
                "/boundary_scan.gif");
    }

    @Override
    public SecurityScanConfig createNewSecurityScan(String name) {
        SecurityScanConfig securityCheckConfig = SecurityScanConfig.Factory.newInstance();
        securityCheckConfig.setType(BoundarySecurityScan.TYPE);
        securityCheckConfig.setName(name);
        return securityCheckConfig;
    }

    @Override
    public AbstractSecurityScan buildSecurityScan(TestStep testStep, SecurityScanConfig config, ModelItem parent) {
        return new BoundarySecurityScan(testStep, config, parent, "/boundary_scan.gif");
    }

    @Override
    public boolean canCreate(TestStep testStep) {
        return testStep instanceof WsdlTestRequestStep || testStep instanceof RestTestRequestStep;
    }
}
