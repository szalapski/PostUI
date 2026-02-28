

package com.eviware.soapui.impl.support.definition.support;

import com.eviware.soapui.config.DefinitionCacheTypeConfig;
import com.eviware.soapui.config.DefintionPartConfig;
import com.eviware.soapui.impl.support.definition.InterfaceDefinitionPart;
import com.eviware.soapui.support.xml.XmlUtils;
import org.w3c.dom.Node;

public class ConfigInterfaceDefinitionPart implements InterfaceDefinitionPart {
    private DefintionPartConfig config;
    private boolean isRoot;
    private DefinitionCacheTypeConfig.Enum type;

    public ConfigInterfaceDefinitionPart(DefintionPartConfig config, boolean isRoot, DefinitionCacheTypeConfig.Enum type) {
        this.config = config;
        this.isRoot = isRoot;
        this.type = type;
    }

    public String getUrl() {
        return config.getUrl();
    }

    public String getType() {
        return config.getType();
    }

    public String getContent() {
        if (type == DefinitionCacheTypeConfig.TEXT) {
            Node domNode = config.getContent().getDomNode();
            return XmlUtils.getNodeValue(domNode);
        } else {
            return config.getContent().toString();
        }
    }

    public boolean isRootPart() {
        return isRoot;
    }
}
