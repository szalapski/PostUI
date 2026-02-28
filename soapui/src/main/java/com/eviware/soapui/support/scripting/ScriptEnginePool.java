

package com.eviware.soapui.support.scripting;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.model.ModelItem;

import java.util.Stack;

/**
 * A pool of script engines
 *
 * @author ole.matzura
 */

public class ScriptEnginePool {
    private Stack<SoapUIScriptEngine> scriptEngines = new Stack<>();
    private String script;
    private ModelItem modelItem;
    private int borrowed;
    private String id;

    public ScriptEnginePool(ModelItem modelItem) {
        this.modelItem = modelItem;
    }

    public ScriptEnginePool(String id) {
        this.id = id;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public void returnScriptEngine(SoapUIScriptEngine scriptEngine) {
        synchronized (this) {
            scriptEngines.push(scriptEngine);
            borrowed--;
        }
    }

    public SoapUIScriptEngine getScriptEngine() {
        synchronized (this) {
            if (scriptEngines.isEmpty()) {
                if (modelItem != null) {
                    scriptEngines.push(SoapUIScriptEngineRegistry.create(modelItem));
                } else {
                    scriptEngines.push(SoapUIScriptEngineRegistry.getFactory(id).createScriptEngine(null));
                }
            }

            SoapUIScriptEngine result = scriptEngines.pop();
            if (script != null) {
                result.setScript(script);
            }

            borrowed++;

            return result;
        }
    }

    public void release() {
        int waitcount = 10;

        while (borrowed > 0 && waitcount-- > 0) {
            try {
                System.out.println("Waiting for " + borrowed + " script engines");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                SoapUI.logError(e);
            }
        }

        for (SoapUIScriptEngine scriptEngine : scriptEngines) {
            scriptEngine.release();
        }

        scriptEngines.clear();

        if (borrowed > 0) {
            System.out.println("Failed to release " + borrowed + " script engines");
        }
    }
}
