

package com.eviware.soapui.ui.desktop;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.action.swing.ActionList;

import javax.swing.JComponent;

/**
 * Behaviour for a SoapUI Desktop implementation
 *
 * @author ole.matzura
 */

public interface SoapUIDesktop {
    public boolean closeDesktopPanel(DesktopPanel desktopPanel);

    public boolean hasDesktopPanel(ModelItem modelItem);

    public void addDesktopListener(DesktopListener listener);

    public void removeDesktopListener(DesktopListener listener);

    public DesktopPanel showDesktopPanel(ModelItem modelItem);

    public boolean closeDesktopPanel(ModelItem modelItem);

    public ActionList getActions();

    public DesktopPanel[] getDesktopPanels();

    public DesktopPanel getDesktopPanel(ModelItem modelItem);

    public DesktopPanel showDesktopPanel(DesktopPanel desktopPanel);

    public JComponent getDesktopComponent();

    public void transferTo(SoapUIDesktop newDesktop);

    public boolean closeAll();

    public void release();

    public void init();

    public void minimize(DesktopPanel desktopPanel);

    public void maximize(DesktopPanel dp);

    public void showInspector( JComponent component );
}
