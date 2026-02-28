

package com.eviware.soapui.support.components;

import com.eviware.soapui.SoapUI;

import javax.swing.JComponent;

public class JInspectorPanelFactory {
    public static Class<? extends JInspectorPanel> inspectorPanelClass = JInspectorPanelImpl.class;

    public static JInspectorPanel build(JComponent contentComponent) {
        try {
            return inspectorPanelClass.getConstructor(JComponent.class).newInstance(contentComponent);
        } catch (Throwable e) {
            SoapUI.logError(e);
            return null;
        }
    }

    public static JInspectorPanel build(JComponent contentComponent, int orientation) {
        try {
            return inspectorPanelClass.getConstructor(JComponent.class, int.class).newInstance(contentComponent,
                    orientation);
        } catch (Throwable e) {
            SoapUI.logError(e);
            return null;
        }
    }
}
