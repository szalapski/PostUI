

package com.eviware.soapui.impl.wsdl.actions.support;

import com.eviware.soapui.support.HelpActionMarker;
import com.eviware.soapui.support.Tools;
import com.eviware.soapui.support.UISupport;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;

/**
 * Opens a URL in the external browser
 *
 * @author Ole.Matzura
 */

public class OpenUrlAction extends AbstractAction implements HelpActionMarker {
    private final String url;

    public OpenUrlAction(String title, String url) {
        this(title, url, null);
    }

    public OpenUrlAction(String title, String url, KeyStroke accelerator) {
        super(title);
        this.url = url;

        putValue(Action.SHORT_DESCRIPTION, title);
        if (accelerator != null) {
            putValue(Action.ACCELERATOR_KEY, accelerator);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (url == null) {
            UISupport.showErrorMessage("Missing url");
        } else {
            Tools.openURL(url);
        }
    }
}
