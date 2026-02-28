

package com.eviware.soapui.support.components;

import com.eviware.soapui.support.action.swing.ActionList;

import java.util.Map;

/**
 * Behavior of a configuration dialog
 *
 * @author Ole.Matzura
 */

public interface ConfigurationDialog {
    public boolean show(Map<String, String> values);

    public void hide();

    public void addTextField(String name, String tooltip);

    public void addTextField(String name, String tooltip, FieldType type);

    public void addCheckBox(String caption, String label, boolean selected);

    public void addComboBox(String label, Object[] objects, String tooltip);

    public void setValues(String id, String[] values);

    public void addComboBox(String label, String tooltip);

    public ActionList getActions();

    public void getValues(Map<String, String> values);

    public enum FieldType {
        TEXT, DIRECTORY, FILE, URL, JAVA_PACKAGE, JAVA_CLASS
    }
}
