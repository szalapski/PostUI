

package com.eviware.soapui.support.scripting;

/**
 * Behaviour for a script engine
 *
 * @author ole.matzura
 */

public interface SoapUIScriptEngine {
    public void setScript(String scriptText);

    public void setVariable(String name, Object value);

    public void clearVariables();

    public Object run() throws Exception;

    public void release();

    public void compile() throws Exception;
}
