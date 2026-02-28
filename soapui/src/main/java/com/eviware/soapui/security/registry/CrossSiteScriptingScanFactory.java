

package com.eviware.soapui.security.registry;

import com.eviware.soapui.config.SecurityScanConfig;
import com.eviware.soapui.impl.wsdl.teststeps.HttpTestRequestStep;
import com.eviware.soapui.impl.wsdl.teststeps.RestTestRequestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.security.scan.AbstractSecurityScan;
import com.eviware.soapui.security.scan.CrossSiteScriptingScan;

/**
 * Factory for creation cross site scripting scan
 *
 * @author SoapUI team
 */

public class CrossSiteScriptingScanFactory extends AbstractSecurityScanFactory {

    public CrossSiteScriptingScanFactory() {
        super(CrossSiteScriptingScan.TYPE, CrossSiteScriptingScan.NAME, "Preforms a scan for Cross Site Scripting",
                "/cross_site_script_scan.gif");
    }

    public boolean canCreate(TestStep testStep) {
        return testStep instanceof WsdlTestRequestStep || testStep instanceof RestTestRequestStep || testStep instanceof HttpTestRequestStep;
    }

    @Override
    public AbstractSecurityScan buildSecurityScan(TestStep testStep, SecurityScanConfig config, ModelItem parent) {
        return new CrossSiteScriptingScan(testStep, config, parent, "/cross_site_script_scan.gif");
    }

    @Override
    public SecurityScanConfig createNewSecurityScan(String name) {
        SecurityScanConfig securityCheckConfig = SecurityScanConfig.Factory.newInstance();
        securityCheckConfig.setType(CrossSiteScriptingScan.TYPE);
        securityCheckConfig.setName(name);
        return securityCheckConfig;
    }

}
