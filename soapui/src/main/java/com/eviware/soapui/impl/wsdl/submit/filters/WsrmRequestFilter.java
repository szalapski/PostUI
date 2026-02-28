

package com.eviware.soapui.impl.wsdl.submit.filters;

import com.eviware.soapui.impl.support.AbstractHttpRequest;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.submit.transports.http.BaseHttpRequestTransport;
import com.eviware.soapui.impl.wsdl.submit.transports.http.ExtendedHttpMethod;
import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.impl.wsdl.support.wsrm.WsrmContainer;
import com.eviware.soapui.impl.wsdl.support.wsrm.WsrmUtils;
import com.eviware.soapui.model.iface.SubmitContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WsrmRequestFilter extends AbstractRequestFilter {
    public final static Logger log = LogManager.getLogger(WsrmRequestFilter.class);

    public void filterAbstractHttpRequest(SubmitContext context, AbstractHttpRequest<?> wsdlRequest) {
        if (!(wsdlRequest instanceof WsrmContainer) || !((WsrmContainer) wsdlRequest).isWsrmEnabled()
                || (((WsrmContainer) wsdlRequest).getWsrmConfig().getSequenceIdentifier() == null)) {
            return;
        }

        String content = (String) context.getProperty(BaseHttpRequestTransport.REQUEST_CONTENT);
        if (content == null) {
            log.warn("Missing request content in context, skipping ws-addressing");
        } else {
            ExtendedHttpMethod httpMethod = (ExtendedHttpMethod) context
                    .getProperty(BaseHttpRequestTransport.HTTP_METHOD);
            WsdlOperation operation = ((WsdlRequest) wsdlRequest).getOperation();
            // TODO check UsingAddressing for particular endpoint when running a
            // request
            // ((WsdlRequest)wsdlRequest).getEndpoint();
            SoapVersion soapVersion = operation.getInterface().getSoapVersion();
            String identifier = ((WsdlRequest) wsdlRequest).getWsrmConfig().getSequenceIdentifier();
            long msgNumber = ((WsdlRequest) wsdlRequest).getWsrmConfig().getLastMessageId();

            content = new WsrmUtils(content, soapVersion).createNewWSReliableMessagingRequest(
                    (WsdlRequest) wsdlRequest, identifier, msgNumber, wsdlRequest.getEndpoint());
            if (content != null) {
                context.setProperty(BaseHttpRequestTransport.REQUEST_CONTENT, content);
            }
        }
    }

}
