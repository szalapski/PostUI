

package com.eviware.soapui.autoupdate;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.ActionEvent;

public class VersionUpdateAction extends AbstractAction {

    SoapUIUpdateProvider updateProvider;

    public VersionUpdateAction() {
        super("Check for Updates");
        putValue(Action.SHORT_DESCRIPTION, "Checks if newer version is available");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateProvider.showUpdateStatus();
    }

}
