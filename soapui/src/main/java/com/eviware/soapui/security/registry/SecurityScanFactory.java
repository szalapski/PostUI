

package com.eviware.soapui.security.registry;

import com.eviware.soapui.config.SecurityScanConfig;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.security.SecurityScan;
import com.eviware.soapui.model.testsuite.TestStep;

public interface SecurityScanFactory {
    public SecurityScanConfig createNewSecurityScan(String name);

    public SecurityScan buildSecurityScan(TestStep testStep, SecurityScanConfig config, ModelItem parent);

    public String getSecurityScanType();

    /**
     * True for test step on which this check could be applied.
     *
     * @return
     */
    public boolean canCreate(TestStep testStep);

    public String getSecurityScanName();

    public String getSecurityScanDescription();

    public String getSecurityScanIconPath();
}
