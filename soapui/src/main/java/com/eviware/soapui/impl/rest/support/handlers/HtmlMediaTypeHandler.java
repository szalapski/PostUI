

package com.eviware.soapui.impl.rest.support.handlers;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.rest.support.MediaTypeHandler;
import com.eviware.soapui.impl.wsdl.submit.transports.http.HttpResponse;
import com.eviware.soapui.model.iface.TypedContent;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.xml.XmlUtils;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;

import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class HtmlMediaTypeHandler implements MediaTypeHandler {
    public boolean canHandle(String contentType) {
        return contentType != null && contentType.toLowerCase().contains("text/html");
    }

    @Override
    public String createXmlRepresentation(HttpResponse response) {
        return createXmlRepresentation((TypedContent)response);
    }

    public String createXmlRepresentation(TypedContent typedContent) {
        String content = typedContent == null ? null : typedContent.getContentAsString();
        if (!StringUtils.hasContent(content)) {
            return "<xml/>";
        }

        try {
            // XmlObject.Factory.parse( new ByteArrayInputStream(
            // content.getBytes() ) );
            XmlUtils.createXmlObject(new ByteArrayInputStream(content.getBytes()));
            return content;
        } catch (Exception e) {
            // fall through, this wasn't xml
        }

        try {
            Tidy tidy = new Tidy();
            tidy.setXmlOut(true);
            tidy.setShowWarnings(false);
            tidy.setErrout(new PrintWriter(new StringWriter()));
            // tidy.setQuiet(true);
            tidy.setNumEntities(true);
            tidy.setQuoteNbsp(true);
            tidy.setFixUri(false);

            Document document = tidy.parseDOM(new ByteArrayInputStream(content.getBytes()), null);
            StringWriter writer = new StringWriter();
            XmlUtils.serializePretty(document, writer);
            return writer.toString();
        } catch (Throwable e) {
            SoapUI.logError(e);
        }
        return null;
    }
}
