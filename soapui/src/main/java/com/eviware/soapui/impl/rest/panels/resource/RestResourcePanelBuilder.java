

package com.eviware.soapui.impl.rest.panels.resource;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.rest.RestResource;
import com.eviware.soapui.support.components.JPropertiesTable;

import java.awt.Component;

/**
 * PanelBuilder for WsdlInterface
 *
 * @author Ole.Matzura
 */

public class RestResourcePanelBuilder extends EmptyPanelBuilder<RestResource> {
    public RestResourcePanelBuilder() {
    }

    public RestResourceDesktopPanel buildDesktopPanel(RestResource resource) {
        return new RestResourceDesktopPanel(resource);
    }

    public boolean hasDesktopPanel() {
        return true;
    }

    public Component buildOverviewPanel(RestResource service) {
        JPropertiesTable<RestResource> table = new JPropertiesTable<>("Resource Properties");
        table.addProperty("Name", "name", true);
        table.addProperty("Description", "description", true);
        table.addProperty("Path", "path", true);

        table.setPropertyObject(service);

        return table;
    }

    public boolean hasOverviewPanel() {
        return true;
    }
}
