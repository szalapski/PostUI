

package com.eviware.soapui.impl.wsdl.support;

import com.eviware.soapui.impl.wsdl.support.xsd.SchemaLoader;
import com.eviware.soapui.support.xml.XmlUtils;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

import java.net.URL;

public class UrlSchemaLoader implements SchemaLoader {
    private String baseURI;

    public UrlSchemaLoader(String baseURI) {
        this.baseURI = baseURI;
    }

    public XmlObject loadXmlObject(String wsdlUrl, XmlOptions options) throws Exception {
        // return XmlObject.Factory.parse( new URL( wsdlUrl ), options );
        return XmlUtils.createXmlObject(new URL(wsdlUrl), options);
    }

    public String getBaseURI() {
        return baseURI;
    }
}
