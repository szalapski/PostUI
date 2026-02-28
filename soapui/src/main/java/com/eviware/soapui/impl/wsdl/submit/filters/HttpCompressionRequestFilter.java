

package com.eviware.soapui.impl.wsdl.submit.filters;

import com.eviware.soapui.impl.support.AbstractHttpRequest;
import com.eviware.soapui.impl.wsdl.submit.transports.http.BaseHttpRequestTransport;
import com.eviware.soapui.impl.wsdl.submit.transports.http.ExtendedHttpMethod;
import com.eviware.soapui.impl.wsdl.support.CompressionSupport;
import com.eviware.soapui.model.iface.SubmitContext;
import com.eviware.soapui.model.settings.Settings;
import com.eviware.soapui.settings.HttpSettings;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayOutputStream;

public class HttpCompressionRequestFilter extends AbstractRequestFilter {
    private final static Logger log = LogManager.getLogger(HttpCompressionRequestFilter.class);

    @Override
    public void filterAbstractHttpRequest(SubmitContext context, AbstractHttpRequest<?> httpRequest) {
        Settings settings = httpRequest.getSettings();
        String compressionAlg = settings.getString(HttpSettings.REQUEST_COMPRESSION, "None");
        if (!"None".equals(compressionAlg)) {
            try {
                ExtendedHttpMethod method = (ExtendedHttpMethod) context
                        .getProperty(BaseHttpRequestTransport.HTTP_METHOD);
                if (method instanceof HttpEntityEnclosingRequest) {
                    HttpEntity requestEntity = ((HttpEntityEnclosingRequest) method).getEntity();
                    if (requestEntity != null) {
                        ByteArrayOutputStream tempOut = new ByteArrayOutputStream();
                        requestEntity.writeTo(tempOut);

                        byte[] compressedData = CompressionSupport.compress(compressionAlg, tempOut.toByteArray());
                        ((HttpEntityEnclosingRequest) method).setEntity(new ByteArrayEntity(compressedData));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
