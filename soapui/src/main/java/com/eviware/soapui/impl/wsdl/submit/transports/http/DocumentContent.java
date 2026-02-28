

package com.eviware.soapui.impl.wsdl.submit.transports.http;

import com.eviware.soapui.model.iface.TypedContent;

public class DocumentContent implements TypedContent {

    private final String contentType;
    private final String contentAsString;

    public DocumentContent(String contentType, String contentAsString) {
        this.contentAsString = contentAsString;
        this.contentType = contentType;
    }

    @Override
    public String getContentAsString() {
        return contentAsString;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public long getContentLength() {
        return getContentAsString() == null ? 0 : getContentAsString().length();
    }

    public DocumentContent withContent(String newContent){
        return new DocumentContent(contentType, newContent);
    }

    public DocumentContent withContentType(String newContentType){
        return new DocumentContent(newContentType, contentAsString);
    }
}
