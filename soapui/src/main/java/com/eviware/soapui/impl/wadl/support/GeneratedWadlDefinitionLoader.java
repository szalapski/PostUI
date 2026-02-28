

package com.eviware.soapui.impl.wadl.support;

import com.eviware.soapui.impl.rest.RestService;
import com.eviware.soapui.impl.rest.WadlGenerator;
import com.eviware.soapui.impl.rest.panels.request.inspectors.schema.InferredSchemaManager;
import com.eviware.soapui.impl.support.definition.support.AbstractDefinitionLoader;
import com.eviware.soapui.support.xml.XmlUtils;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

public class GeneratedWadlDefinitionLoader extends AbstractDefinitionLoader {
    private RestService restService;

    public GeneratedWadlDefinitionLoader(RestService restService) {
        this.restService = restService;
    }

    public XmlObject loadXmlObject(String wsdlUrl, XmlOptions options) throws Exception {
        if (wsdlUrl.toLowerCase().endsWith(".xsd"))
        // return XmlObject.Factory.parse(
        // InferredSchemaManager.getInferredSchema( restService
        // ).getXsdForNamespace(
        // InferredSchemaManager.namespaceForFilename( wsdlUrl ) ) );
        {
            return XmlUtils.createXmlObject(InferredSchemaManager.getInferredSchema(restService).getXsdForNamespace(
                    InferredSchemaManager.namespaceForFilename(wsdlUrl)));
        }
        return new WadlGenerator(restService).generateWadl();
    }

    public String getBaseURI() {
        return restService.getName() + ".wadl";
    }

    public void setNewBaseURI(String uri) {
        // not implemented
    }

    public String getFirstNewURI() {
        return getBaseURI();
    }
}
