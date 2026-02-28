

package com.eviware.soapui.support.scripting;

import com.eviware.soapui.model.ModelItem;

/**
 * Creates a specific ScriptEngine for the specified ModelItem
 *
 * @author ole.matzura
 */

public interface SoapUIScriptEngineFactory {
    public SoapUIScriptEngine createScriptEngine(ModelItem modelItem);

    public SoapUIScriptGenerator createCodeGenerator(ModelItem modelItem);
}
