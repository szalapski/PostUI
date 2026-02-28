

package com.eviware.soapui.impl.support.actions;

import com.eviware.soapui.analytics.Analytics;
import com.eviware.soapui.impl.wsdl.support.HelpUrls;
import com.eviware.soapui.support.HelpActionMarker;
import com.eviware.soapui.support.Tools;
import com.eviware.soapui.support.UISupport;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;

import static com.eviware.soapui.analytics.SoapUIActions.APPLY_TRIAL_FROM_TOOLBAR;
import static com.eviware.soapui.analytics.SoapUIActions.OPEN_FORUM_FROM_TOOLBAR;

/**
 * Shows an online help page
 *
 * @author Ole.Matzura
 */

public class ShowOnlineHelpAction extends AbstractAction implements HelpActionMarker {
    private final String url;
    private String helpurl;

    public ShowOnlineHelpAction(String url) {
        this("Online Help", url, UISupport.getKeyStroke("F1"));
    }

    public ShowOnlineHelpAction(String title, String url) {
        this(title, url, null, null, null);
    }

    public ShowOnlineHelpAction(String title, String url, String description) {
        this(title, url, null, description, null);
    }

    public ShowOnlineHelpAction(String title, String url, String description, String iconPath) {
        this(title, url, null, description, iconPath);
    }

    public ShowOnlineHelpAction(String title, String url, KeyStroke accelerator) {
        this(title, url, accelerator, null);
    }

    public ShowOnlineHelpAction(String title, String url, KeyStroke accelerator, String description) {
        this(title, url, accelerator, description, null);
    }

    public ShowOnlineHelpAction(String title, String url, KeyStroke accelerator, String description, String iconPath) {
        super(title);
        this.url = url;
        putValue(Action.SHORT_DESCRIPTION, description == null ? "Show online help" : description);
        if (accelerator != null) {
            putValue(Action.ACCELERATOR_KEY, accelerator);
        }

        putValue(Action.SMALL_ICON, iconPath == null ? UISupport.HELP_ICON : UISupport.createImageIcon(iconPath));
    }

    public void actionPerformed(ActionEvent e) {

        Integer mods = e.getModifiers();
        String helpUrl = Tools.modifyUrl(url, mods);
        Tools.openURL(helpUrl);
        if (url.equals(HelpUrls.COMMUNITY_HELP_URL)) {
            Analytics.trackAction(OPEN_FORUM_FROM_TOOLBAR);
        } else if (url.equals(HelpUrls.TRIAL_URL)) {
            Analytics.trackAction(APPLY_TRIAL_FROM_TOOLBAR);
        }
    }
}
