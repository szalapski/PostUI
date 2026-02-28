

package com.eviware.soapui.security.ui;

import com.eviware.soapui.model.security.SecurityScan;
import com.eviware.x.form.support.AField;
import com.eviware.x.form.support.AField.AFieldType;
import com.eviware.x.form.support.AForm;

public class SecurityConfigurationDialogBuilder {

    public SecurityConfigurationDialog buildSecurityScanConfigurationDialog(SecurityScan securityCheck) {
        return new SecurityConfigurationDialog(securityCheck);
    }

    @AForm(description = "Strategy", name = "Strategy")
    protected interface Strategy {

        @AField(description = "Strategy", name = "Select strategy", type = AFieldType.RADIOGROUP)
        public final static String STRATEGY = "Select strategy";

        @AField(description = "Request Delay", name = "Request Delay (ms)", type = AFieldType.INT)
        public final static String DELAY = "Request Delay (ms)";

        @AField(description = "Apply to Failed TestSteps", name = "Apply to Failed TestSteps", type = AFieldType.BOOLEAN)
        public final static String APPLY_TO_FAILED_STEPS = "Apply to Failed TestSteps";

        // indicates if security scan should run only once in case of DataSource
        // Loop involved
        @AField(description = "Run only once", name = "Run only once", type = AFieldType.BOOLEAN)
        public final static String RUN_ONLY_ONCE = "Run only once";

    }

}
