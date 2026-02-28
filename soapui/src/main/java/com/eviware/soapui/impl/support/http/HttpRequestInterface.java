

package com.eviware.soapui.impl.support.http;

import com.eviware.soapui.config.AbstractRequestConfig;
import com.eviware.soapui.impl.rest.RestRequestInterface;
import com.eviware.soapui.impl.rest.support.RestParamsPropertyHolder;
import com.eviware.soapui.impl.support.AbstractHttpRequestInterface;
import com.eviware.soapui.impl.wsdl.MutableAttachmentContainer;
import com.eviware.soapui.impl.wsdl.MutableTestPropertyHolder;
import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.model.propertyexpansion.PropertyExpansionContainer;

public interface HttpRequestInterface<T extends AbstractRequestConfig> extends AbstractHttpRequestInterface<T>,
        Request, MutableTestPropertyHolder, PropertyExpansionContainer, MutableAttachmentContainer, MediaType {

    public void setMethod(RestRequestInterface.HttpMethod method);

    public boolean hasRequestBody();

    public RestParamsPropertyHolder getParams();

    public boolean isPostQueryString();

    public void setPostQueryString(boolean b);

    public String getResponseContentAsXml();

    public void updateConfig(T request);

    public String getPath();

    public String getMultiValueDelimiter();

}
