

package com.eviware.soapui.ui.desktop;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.action.swing.ActionList;

import javax.swing.JComponent;

/**
 * null-desktop used when running from command-line, etc
 *
 * @author Ole
 */

public class NullDesktop implements SoapUIDesktop {
    public void addDesktopListener(DesktopListener listener) {
    }

    public boolean closeAll() {
        return false;
    }

    public boolean closeDesktopPanel(DesktopPanel desktopPanel) {
        return false;
    }

    public boolean closeDesktopPanel(ModelItem modelItem) {
        return false;
    }

    public ActionList getActions() {
        return null;
    }

    public JComponent getDesktopComponent() {
        return null;
    }

    public DesktopPanel getDesktopPanel(ModelItem modelItem) {
        return null;
    }

    public DesktopPanel[] getDesktopPanels() {
        return null;
    }

    public boolean hasDesktopPanel(ModelItem modelItem) {
        return false;
    }

    public void init() {
    }

    public void maximize(DesktopPanel dp) {
    }

    @Override
    public void showInspector(JComponent component) {

    }

    public void minimize(DesktopPanel desktopPanel) {
    }

    public void release() {
    }

    public void removeDesktopListener(DesktopListener listener) {
    }

    public DesktopPanel showDesktopPanel(ModelItem modelItem) {
        return null;
    }

    public DesktopPanel showDesktopPanel(DesktopPanel desktopPanel) {
        return null;
    }

    public void transferTo(SoapUIDesktop newDesktop) {
    }
}
