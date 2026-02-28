

package com.eviware.soapui.impl.wsdl.panels.teststeps.support;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.settings.Settings;

import javax.swing.Action;
import java.beans.PropertyChangeListener;

/**
 * Model used by custom GrooyEditor
 *
 * @author ole.matzura
 */

public interface GroovyEditorModel {
    public String[] getKeywords();

    public String getScript();

    public void setScript(String text);

    public Action getRunAction();

    public Settings getSettings();

    public String getScriptName();

    public void addPropertyChangeListener(PropertyChangeListener listener);

    public void removePropertyChangeListener(PropertyChangeListener listener);

    public ModelItem getModelItem();
}
