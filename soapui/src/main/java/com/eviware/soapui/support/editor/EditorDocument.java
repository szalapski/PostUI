

package com.eviware.soapui.support.editor;

import com.eviware.soapui.impl.wsdl.submit.transports.http.DocumentContent;
import com.eviware.soapui.support.PropertyChangeNotifier;

import javax.annotation.Nonnull;

public interface EditorDocument extends PropertyChangeNotifier {
    String DOCUMENT_PROPERTY = EditorDocument.class.getName() + "@content";

    abstract void release();

    @Nonnull
    DocumentContent getDocumentContent(Format format);

    void setDocumentContent(DocumentContent documentContent);

    public static enum Format {
        RAW, XML
    }

    String getContentType();
}
