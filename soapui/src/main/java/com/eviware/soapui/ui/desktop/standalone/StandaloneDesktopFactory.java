

package com.eviware.soapui.ui.desktop.standalone;

import com.eviware.soapui.model.workspace.Workspace;
import com.eviware.soapui.ui.desktop.DesktopFactory;
import com.eviware.soapui.ui.desktop.SoapUIDesktop;

/**
 * Creates a StandaloneDesktop
 *
 * @author ole.matzura
 */

public class StandaloneDesktopFactory implements DesktopFactory {
    public SoapUIDesktop createDesktop(Workspace workspace) {
        return new StandaloneDesktop(workspace);
    }
}
