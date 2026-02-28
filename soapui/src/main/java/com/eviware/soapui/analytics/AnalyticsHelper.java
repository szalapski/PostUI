

package com.eviware.soapui.analytics;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.analytics.providers.OSUserProviderFactory;
import com.eviware.soapui.settings.UISettings;
import com.smartbear.analytics.AnalyticsManager;
import com.smartbear.analytics.api.AnalyticsProviderFactory;
import com.smartbear.analytics.impl.SoapUIOSMixpanelProviderFactory;

public class AnalyticsHelper {
    private static boolean initialized = false;

    public static void initializeAnalytics() {
        if (initialized) {
            return;
        }
        initialized = true;
        UniqueUserIdentifier userIdentifier = UniqueUserIdentifier.getInstance();
        AnalyticsManager manager = com.smartbear.analytics.Analytics.getAnalyticsManager();
        manager.setExecutorService(SoapUI.getThreadPool());
        SoapUIProductInfo productInfo = SoapUIProductInfo.getInstance();
        manager.registerAnalyticsProviderFactory(new OSUserProviderFactory(productInfo));
        if (SoapUI.getSettings().getBoolean(UISettings.DISABLE_ANALYTICS, false)) {
            return;
        }
        manager.registerAnalyticsProviderFactory(new SoapUIOSMixpanelProviderFactory(productInfo, userIdentifier, AnalyticsProviderFactory.HandleType.MANDATORY));
        manager.registerAnalyticsProviderFactory(new SoapUIOSMixpanelProviderFactory(productInfo, userIdentifier, AnalyticsProviderFactory.HandleType.USER_ALLOWED));
    }
}
