

package com.eviware.soapui.impl.wsdl.submit.transports.http.support.attachments;

import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;

import javax.activation.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * DataSource for an existing WsdlRequest
 *
 * @author ole.matzura
 */

public class WsdlRequestDataSource implements DataSource {
    private final WsdlRequest wsdlRequest;
    private final String requestContent;
    private final boolean isXOP;

    public WsdlRequestDataSource(WsdlRequest wsdlRequest, String requestContent, boolean isXOP) {
        this.wsdlRequest = wsdlRequest;
        this.requestContent = requestContent;
        this.isXOP = isXOP;
    }

    public String getContentType() {
        SoapVersion soapVersion = wsdlRequest.getOperation().getInterface().getSoapVersion();

        if (isXOP) {
            return AttachmentUtils.buildRootPartContentType(wsdlRequest.getOperation().getName(), soapVersion);
        } else {
            return soapVersion.getContentType() + "; charset=UTF-8";
        }
    }

    public InputStream getInputStream() throws IOException {
        byte[] bytes = requestContent.getBytes("UTF-8");
        return new ByteArrayInputStream(bytes);
    }

    public String getName() {
        return wsdlRequest.getName();
    }

    public OutputStream getOutputStream() throws IOException {
        return null;
    }
}
