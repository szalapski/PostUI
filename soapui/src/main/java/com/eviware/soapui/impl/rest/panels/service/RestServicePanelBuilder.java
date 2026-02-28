

package com.eviware.soapui.impl.rest.panels.service;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.rest.RestService;
import com.eviware.soapui.support.components.JPropertiesTable;

import java.awt.Component;

/**
 * PanelBuilder for WsdlInterface
 *
 * @author Ole.Matzura
 */

public class RestServicePanelBuilder extends EmptyPanelBuilder<RestService> {
    public RestServicePanelBuilder() {
    }

    public RestServiceDesktopPanel buildDesktopPanel(RestService service) {
        return new RestServiceDesktopPanel(service);
    }

    public boolean hasDesktopPanel() {
        return true;
    }

    public Component buildOverviewPanel(RestService service) {
        JPropertiesTable<RestService> table = new JPropertiesTable<>("Service Properties");
        table.addProperty("Name", "name", true);
        table.addProperty("Description", "description", true);
        table.addProperty("Base Path", "basePath", true);
        table.addProperty("WADL", "wadlUrl", !service.isGenerated());
        table.addProperty("Generated", "generated", false);

        table.setPropertyObject(service);

        return table;
    }

    public boolean hasOverviewPanel() {
        return true;
    }
}
