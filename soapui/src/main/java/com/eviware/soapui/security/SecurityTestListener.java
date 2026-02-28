

package com.eviware.soapui.security;

import com.eviware.soapui.model.security.SecurityScan;

/**
 * Listener for security check events
 *
 * @author dragica.soldo
 */

public interface SecurityTestListener {
    public void securityScanAdded(SecurityScan securityScan);

    public void securityScanRemoved(SecurityScan securityScan);

}
