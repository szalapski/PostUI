

package com.eviware.soapui.support.scripting;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.support.ModelSupport;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.scripting.groovy.GroovyScriptEngineFactory;
import com.eviware.soapui.support.scripting.js.JsScriptEngineFactory;
import com.eviware.soapui.support.types.StringList;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry of available script engines
 *
 * @author ole.matzura
 */

public class SoapUIScriptEngineRegistry {
    public static final String DEFAULT_SCRIPT_ENGINE_ID = GroovyScriptEngineFactory.ID;

    private static Map<String, SoapUIScriptEngineFactory> factories = new HashMap<>();

    public static void registerScriptEngine(String id, SoapUIScriptEngineFactory factory) {
        factories.put(id, factory);
    }

    public static SoapUIScriptEngineFactory getFactory(String id) {
        return factories.get(id);
    }

    public static SoapUIScriptEngine create(ModelItem modelItem) {
        return factories.get(getScriptEngineId(modelItem)).createScriptEngine(modelItem);
    }

    public static String getScriptEngineId(ModelItem modelItem) {
        WsdlProject project = (WsdlProject) ModelSupport.getModelItemProject(modelItem);

        String scriptEngineId = null;
        if (project != null) {
            scriptEngineId = project.getDefaultScriptLanguage();
        }

        if (StringUtils.isNullOrEmpty(scriptEngineId)) {
            scriptEngineId = DEFAULT_SCRIPT_ENGINE_ID;
        }

        return scriptEngineId;
    }

    public static SoapUIScriptGenerator createScriptGenerator(ModelItem modelItem) {
        WsdlProject project = (WsdlProject) ModelSupport.getModelItemProject(modelItem);

        String scriptEngineId = project.getDefaultScriptLanguage();
        if (StringUtils.isNullOrEmpty(scriptEngineId)) {
            scriptEngineId = DEFAULT_SCRIPT_ENGINE_ID;
        }

        return factories.get(scriptEngineId).createCodeGenerator(modelItem);
    }

    static {
        registerScriptEngine(GroovyScriptEngineFactory.ID, new GroovyScriptEngineFactory());
        registerScriptEngine(JsScriptEngineFactory.ID, new JsScriptEngineFactory());
    }

    public static String[] getAvailableEngineIds() {
        return new StringList(factories.keySet()).toStringArray();
    }
}
