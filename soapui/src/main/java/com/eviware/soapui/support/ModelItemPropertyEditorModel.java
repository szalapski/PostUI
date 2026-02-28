

package com.eviware.soapui.support;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.settings.Settings;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ModelItemPropertyEditorModel<T extends ModelItem> extends AbstractEditorModel implements
        PropertyChangeListener {
    private T modelItem;
    private String propertyName;

    public ModelItemPropertyEditorModel(T modelItem, String propertyName) {
        this.modelItem = modelItem;
        this.propertyName = propertyName;

        modelItem.addPropertyChangeListener(propertyName, this);
    }

    public Settings getSettings() {
        return modelItem.getSettings();
    }

    public String getEditorText() {
        try {
            Object value = PropertyUtils.getSimpleProperty(modelItem, propertyName);
            return value == null ? "" : String.valueOf(value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void setEditorText(String text) {
        try {
            PropertyUtils.setSimpleProperty(modelItem, propertyName, text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release() {
        super.release();

        modelItem.removePropertyChangeListener(propertyName, this);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        fireEditorTextChanged(String.valueOf(evt.getOldValue()), String.valueOf(evt.getNewValue()));
    }
}
