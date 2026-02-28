

package com.eviware.soapui.support.action.support;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.action.SoapUIAction;
import com.eviware.soapui.support.action.SoapUIActionMapping;

/**
 * A standalone SoapUIActionMapping
 *
 * @author ole.matzura
 */

public class StandaloneActionMapping<T extends ModelItem> implements SoapUIActionMapping<T> {
    private final SoapUIAction<T> action;
    private String keyStroke;
    private String description;
    private String name;
    private Object param;
    private String iconPath;
    private boolean enabled = true;

    public StandaloneActionMapping(SoapUIAction<T> action, String keyStroke, String iconPath) {
        if (action == null) {
            throw new IllegalArgumentException("action can't be null");
        }
        this.action = action;
        this.keyStroke = keyStroke;
        this.iconPath = iconPath;
    }

    public StandaloneActionMapping(SoapUIAction<T> action, String keyStroke) {
        this.action = action;
        this.keyStroke = keyStroke;
    }

    public StandaloneActionMapping(SoapUIAction<T> action) {
        this.action = action;
    }

    public SoapUIAction<T> getAction() {
        return action;
    }

    public String getActionId() {
        return action.getClass().getSimpleName();
    }

    public String getIconPath() {
        return iconPath;
    }

    public String getKeyStroke() {
        return keyStroke;
    }

    public Object getParam() {
        return param;
    }

    public boolean isDefault() {
        return false;
    }

    public String getDescription() {
        return description == null ? action.getDescription() : description;
    }

    public String getName() {
        return name == null ? action.getName() : name;
    }

    public SoapUIActionMapping<T> setDescription(String description) {
        this.description = description;
        return this;
    }

    public SoapUIActionMapping<T> setName(String name) {
        this.name = name;
        return this;
    }

    public SoapUIActionMapping<T> setParam(Object param) {
        this.param = param;
        return this;
    }

    public String getId() {
        return null;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public SoapUIActionMapping<T> setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    @Override
    public int getToolbarIndex() {
        return 0;
    }
}
