

package com.eviware.soapui.impl.support.definition.export;

import com.eviware.soapui.support.types.StringToStringMap;

public interface DefinitionExporter {
    String export(String folderName) throws Exception;

    StringToStringMap createFilesForExport(String urlPrefix) throws Exception;
}
