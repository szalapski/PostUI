

package com.eviware.soapui.impl.support.definition;

import java.util.List;

public interface DefinitionCache {
    public boolean validate();

    public void update(DefinitionLoader currentLoader) throws Exception;

    public List<InterfaceDefinitionPart> getDefinitionParts() throws Exception;

    public InterfaceDefinitionPart getRootPart();

    public void clear();
}
