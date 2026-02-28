

package com.eviware.soapui.actions;

import com.eviware.soapui.autoupdate.SoapUIAutoUpdaterUtils;
import com.eviware.soapui.autoupdate.SoapUIUpdateProvider;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.ActionEvent;

public class VersionUpdateAction extends AbstractAction {

    SoapUIUpdateProvider updateProvider = SoapUIAutoUpdaterUtils.getProvider();

    public VersionUpdateAction() {
        super("Check for updates");
        putValue(Action.SHORT_DESCRIPTION, "Checks if newer version is available");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateProvider.showUpdateStatus();
    }

}
