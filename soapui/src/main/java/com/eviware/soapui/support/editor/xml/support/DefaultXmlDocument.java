

package com.eviware.soapui.support.editor.xml.support;

import com.eviware.soapui.impl.wsdl.submit.transports.http.DocumentContent;
import com.eviware.soapui.support.xml.XmlUtils;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;

import javax.annotation.Nonnull;

/**
 * Default XmlDocument that works on a standard xml string
 *
 * @author ole.matzura
 */

public class DefaultXmlDocument extends AbstractXmlDocument {
    private String xml;
    private SchemaTypeSystem typeSystem;

    public DefaultXmlDocument(String xml) {
        this.xml = xml;
    }

    public DefaultXmlDocument() {
    }

    public void setTypeSystem(SchemaTypeSystem typeSystem) {
        this.typeSystem = typeSystem;
    }

    public SchemaTypeSystem getTypeSystem() {
        if (typeSystem != null) {
            return typeSystem;
        }

        try {
            typeSystem = XmlUtils.createXmlObject(xml).schemaType().getTypeSystem();
            return typeSystem;
        } catch (Exception e) {
            return XmlBeans.getBuiltinTypeSystem();
        }
    }

    @Override
    public void setDocumentContent(DocumentContent documentContent) {
        this.xml = documentContent.getContentAsString();
        if ("<not-xml/>".equals(documentContent.getContentAsString())) {
            fireContentChanged();
        }

        fireContentChanged();
    }

    @Override
    public String getContentType() {
        return "application/xml";
    }

    public void release() {
        typeSystem = null;
    }

    @Nonnull
    @Override
    public DocumentContent getDocumentContent(Format format) {
        return new DocumentContent("text/xml", xml);
    }
}
