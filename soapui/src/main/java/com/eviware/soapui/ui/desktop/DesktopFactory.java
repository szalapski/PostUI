

package com.eviware.soapui.ui.desktop;

import com.eviware.soapui.model.workspace.Workspace;

/**
 * Factory for a specific SoapUIDesktop implementation
 *
 * @author ole.matzura
 */

public interface DesktopFactory {
    public SoapUIDesktop createDesktop(Workspace workspace);
}
