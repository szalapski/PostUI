

package com.eviware.soapui.support.components;

import javax.swing.JComponent;
import java.util.List;

public interface JInspectorPanel {
    public <T extends Inspector> T addInspector(final T inspector);

    JComponent getComponent();

    void setDefaultDividerLocation(float v);

    public void activate(Inspector inspector);

    void setCurrentInspector(String s);

    void setDividerLocation(int i);

    void setResizeWeight(double v);

    List<Inspector> getInspectors();

    Inspector getCurrentInspector();

    Inspector getInspectorByTitle(String title);

    void deactivate();

    void removeInspector(Inspector inspector);

    void setContentComponent(JComponent component);

    int getDividerLocation();

    Inspector getInspector(String inspectorId);

    void setInspectorVisible(Inspector inspector, boolean b);

    void setResetDividerLocation();

    void release();
}
