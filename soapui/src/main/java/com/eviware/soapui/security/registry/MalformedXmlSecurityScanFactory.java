

package com.eviware.soapui.security.registry;

import com.eviware.soapui.config.SecurityScanConfig;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.security.scan.AbstractSecurityScan;
import com.eviware.soapui.security.scan.MalformedXmlSecurityScan;

public class MalformedXmlSecurityScanFactory extends AbstractSecurityScanFactory {

    public MalformedXmlSecurityScanFactory() {
        super(MalformedXmlSecurityScan.TYPE, MalformedXmlSecurityScan.NAME,
                "Preforms a scan for Malformed XML Vulerabilities", "/malformed_xml_scan.gif");
    }

    @Override
    public AbstractSecurityScan buildSecurityScan(TestStep testStep, SecurityScanConfig config, ModelItem parent) {
        return new MalformedXmlSecurityScan(testStep, config, parent, "/malformed_xml_scan.gif");
    }

    @Override
    public boolean canCreate(TestStep testStep) {
        return testStep instanceof WsdlTestRequestStep;
    }

    @Override
    public SecurityScanConfig createNewSecurityScan(String name) {
        SecurityScanConfig securityCheckConfig = SecurityScanConfig.Factory.newInstance();
        securityCheckConfig.setType(MalformedXmlSecurityScan.TYPE);
        securityCheckConfig.setName(name);
        return securityCheckConfig;
    }

}
