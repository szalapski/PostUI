

package com.eviware.soapui.impl.support.definition.export;

import com.eviware.soapui.impl.rest.RestService;
import com.eviware.soapui.impl.support.definition.InterfaceDefinition;
import com.eviware.soapui.impl.support.definition.InterfaceDefinitionPart;
import com.eviware.soapui.impl.wsdl.support.Constants;
import net.java.dev.wadl.x2009.x02.ApplicationDocument;
import net.java.dev.wadl.x2009.x02.MethodDocument.Method;
import net.java.dev.wadl.x2009.x02.RepresentationDocument.Representation;
import net.java.dev.wadl.x2009.x02.ResourceDocument.Resource;
import net.java.dev.wadl.x2009.x02.ResourcesDocument.Resources;
import net.java.dev.wadl.x2009.x02.ResponseDocument.Response;
import org.apache.xmlbeans.XmlObject;
import org.w3c.dom.Element;

import java.util.List;

public class WadlDefinitionExporter extends AbstractDefinitionExporter<RestService> {
    public WadlDefinitionExporter(InterfaceDefinition<RestService> definition) {
        super(definition);
    }

    public WadlDefinitionExporter(RestService restService) throws Exception {
        this(restService.getDefinitionContext().getInterfaceDefinition());
    }

    public String export(String folderName) throws Exception {
        setDefinition(getDefinition().getInterface().getWadlContext().regenerateWadl());

        return super.export(folderName);
    }

    protected String[] getLocationXPathsToReplace() {
        return new String[]{
                "declare namespace s='" + getDefinition().getInterface().getWadlVersion()
                        + "' .//s:grammars/s:include/@href",
                "declare namespace s='http://www.w3.org/2001/XMLSchema' .//s:import/@schemaLocation",
                "declare namespace s='http://www.w3.org/2001/XMLSchema' .//s:include/@schemaLocation"};
    }

    @Override
    protected void postProcessing(XmlObject obj, InterfaceDefinitionPart part) {
        if (part.getType().equals(Constants.WADL11_NS)) {
            ApplicationDocument document = (ApplicationDocument) obj;
            for (Resources resources : document.getApplication().getResourcesList()) {
                for (Resource resource : resources.getResourceList()) {
                    for (Method method : resource.getMethodList()) {
                        if (method.getRequest() != null) {
                            fixRepresentations(method.getRequest().getRepresentationList());
                        }

                        for (Response response : method.getResponseList()) {
                            fixRepresentations(response.getRepresentationList());
                        }
                    }
                }
            }
        }
    }

    private void fixRepresentations(List<Representation> representationList) {
        for (Representation representation : representationList) {
            if (!("text/xml".equals(representation.getMediaType()) || "application/xml".equals(representation
                    .getMediaType())) && representation.isSetElement()) {
                String prefix = representation.xgetElement().getDomNode().getNodeValue().split(":")[0];
                representation.unsetElement();
                ((Element) representation.getDomNode()).removeAttribute("xmlns:" + prefix);
            }
        }
    }

}
