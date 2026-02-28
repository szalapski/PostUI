

package com.eviware.soapui.security.registry;

import com.eviware.soapui.config.SecurityScanConfig;
import com.eviware.soapui.impl.wsdl.teststeps.HttpTestRequestStep;
import com.eviware.soapui.impl.wsdl.teststeps.RestTestRequestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.security.scan.AbstractSecurityScan;
import com.eviware.soapui.security.scan.SQLInjectionScan;

/**
 * Factory for creation GroovyScript steps
 *
 * @author SoapUI team
 */

public class SQLInjectionScanFactory extends AbstractSecurityScanFactory {

    public SQLInjectionScanFactory() {
        super(SQLInjectionScan.TYPE, SQLInjectionScan.NAME, "Preforms a scan for SQL Injection Vulnerabilities",
                "/sql_injection_scan.gif");
    }

    public boolean canCreate(TestStep testStep) {
        return testStep instanceof WsdlTestRequestStep || testStep instanceof RestTestRequestStep
                || testStep instanceof HttpTestRequestStep;
    }

    @Override
    public AbstractSecurityScan buildSecurityScan(TestStep testStep, SecurityScanConfig config, ModelItem parent) {
        return new SQLInjectionScan(testStep, config, parent, "/sql_injection_scan.gif");
    }

    @Override
    public SecurityScanConfig createNewSecurityScan(String name) {
        SecurityScanConfig securityCheckConfig = SecurityScanConfig.Factory.newInstance();
        securityCheckConfig.setType(SQLInjectionScan.TYPE);
        securityCheckConfig.setName(name);
        return securityCheckConfig;
    }

}
