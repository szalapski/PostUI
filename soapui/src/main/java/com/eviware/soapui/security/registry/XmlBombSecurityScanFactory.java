

package com.eviware.soapui.security.registry;

import com.eviware.soapui.config.SecurityScanConfig;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.security.scan.AbstractSecurityScan;
import com.eviware.soapui.security.scan.XmlBombSecurityScan;

/**
 * Factory for creation GroovyScript steps
 *
 * @author SoapUI team
 */

public class XmlBombSecurityScanFactory extends AbstractSecurityScanFactory {

    public XmlBombSecurityScanFactory() {
        super(XmlBombSecurityScan.TYPE, XmlBombSecurityScan.NAME, "Performs a scan for XML Bomb Vulnerabilities",
                "/xml_bomb_scan.gif");
    }

    public boolean canCreate(TestStep testStep) {
        return testStep instanceof WsdlTestRequestStep;
    }

    @Override
    public AbstractSecurityScan buildSecurityScan(TestStep testStep, SecurityScanConfig config, ModelItem parent) {
        return new XmlBombSecurityScan(testStep, config, parent, "/xml_bomb_scan.gif");
    }

    @Override
    public SecurityScanConfig createNewSecurityScan(String name) {
        SecurityScanConfig securityCheckConfig = SecurityScanConfig.Factory.newInstance();
        securityCheckConfig.setType(XmlBombSecurityScan.TYPE);
        securityCheckConfig.setName(name);
        return securityCheckConfig;
    }

}
