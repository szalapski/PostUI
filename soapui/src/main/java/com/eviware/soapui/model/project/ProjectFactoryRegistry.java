

package com.eviware.soapui.model.project;

import com.eviware.soapui.impl.wsdl.WsdlProjectFactory;

import java.util.HashMap;
import java.util.Map;

public class ProjectFactoryRegistry {
    private static Map<String, ProjectFactory<?>> factories = new HashMap<>();

    static {
        factories.put(WsdlProjectFactory.WSDL_TYPE, new WsdlProjectFactory());
    }

    public static ProjectFactory<?> getProjectFactory(String projectType) {
        return factories.get(projectType);
    }

    public static void registrerProjectFactory(String projectType, ProjectFactory<?> projectFactory) {
        factories.put(projectType, projectFactory);
    }
}
