

package com.eviware.soapui.impl.wsdl;

import com.eviware.soapui.config.InterfaceConfig;
import com.eviware.soapui.impl.InterfaceFactory;
import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.rest.RestServiceFactory;
import com.eviware.soapui.impl.support.AbstractInterface;
import com.eviware.soapui.support.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class InterfaceFactoryRegistry {
    private static Map<String, InterfaceFactory<?>> factories = new HashMap<>();

    static {
        factories.put(WsdlInterfaceFactory.WSDL_TYPE, new WsdlInterfaceFactory());
        factories.put(RestServiceFactory.REST_TYPE, new RestServiceFactory());
    }

    public static AbstractInterface<?> createNew(WsdlProject project, String type, String name) {
        if (!factories.containsKey(type)) {
            throw new RuntimeException("Unknown interface type [" + type + "]");
        }

        return factories.get(type).createNew(project, name);
    }

    public static AbstractInterface<?> build(WsdlProject project, InterfaceConfig config) {
        String type = config.getType();
        if (StringUtils.isNullOrEmpty(type)) {
            type = WsdlInterfaceFactory.WSDL_TYPE;
        }

        return factories.get(type).build(project, config);
    }
}
